package com.sportgames.config;

import com.sportgames.model.*;
import com.sportgames.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;


public class TestData {

    @Autowired
    private PlaygroundService playgroundService;
    @Autowired
    private UserService userService;
    @Autowired
    private SportService sportService;
    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private UserRoleService userRoleService;

    public void initData() {
        Random random = new Random();
        //USERS
        usersData();
        //SPORTS
        sportsData();
        //PLAYGROUNDS
        String[] playgrounds = playgroundsData();


        for (String p : playgrounds) {
            int r1 = (int) (Math.random() * 7 + 1);
            int r2 = (int) (Math.random() * 15);
            Set<Sport> sports = new HashSet<>();
            sports.addAll(sportService
                    .getAll()
                    .subList(Math.min(r1, r2), Math.max(r1, r2)));
            Playground pg = new Playground(p);
            pg.setSports(sports);
            playgroundService.add(pg);

        }

        int randomer = Math.abs(random.nextInt(30));
        int or1 = randomer % 15;
        int or2 = randomer % 30;

        //EVENTS
        for (int i = 0; i < 50; i++) {
            List<User> userList = new ArrayList<>();
            SportEvent se = new SportEvent();
            Playground pg = playgroundService.get((long) (Math.random() * 3) + 1);

            List<Sport> pgsports = new ArrayList<>(pg.getSports());
            se.setSport(pgsports.get(i % (pgsports.size() == 0 ? 1 : pgsports.size())));

            se.setPlayground(pg);
            se.setUsers(new HashSet<>(userService.getAll().subList(Math.min(or1, or2), Math.max(or1, or2))));
            int randomK = (int) (Math.random() * 25);

            for (int k = 0; k < randomK; k++) {
                userList.add(userService.findById((long) ((Math.random() * 28) + 1)));
            }

            se.setUsers(new HashSet<>(userList));

            //EVENTS DATE AND TIME
            LocalDateTime ldStart = LocalDateTime.of(2019, (int) (Math.random() + 2), (int) (Math.random() * 27 + 1), (int) (Math.random() * 10 + 10), (int) (Math.random() * 59));
            LocalDateTime ldEnd = ldStart.plusMinutes((int) (Math.random() * 75 + 30));
            se.setTimeStart(ldStart);
            se.setTimeEnd(ldEnd);
            sportEventService.add(se);
        }


    }

    private String[] playgroundsData() {
        String[] s = {"Кремль", "Ледовый", "Олимпийский", "Дворец Пионеров"};
        return s;
    }

    private void usersData() {
        userRoleData();

        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setLogin("user" + i);
            user.setPassword(userService.encodePassword("user" + i));
            user.setAutorities(new HashSet<>(randomAutorities()));
            userService.add(user);
        }
    }

    private List<UserRole> randomAutorities() {
        List<UserRole> userRoles = new ArrayList<>();
        int k = (int) (Math.round(Math.random()) + 1);
        for (int i = 0; i < k; i++) {
            if (i == 0) userRoles.add(userRoleService.findByAuthority("ROLE_USER"));
            if (i == 1) userRoles.add(userRoleService.findByAuthority("ROLE_ADMIN"));
        }
        return userRoles;
    }

    private void userRoleData() {
        userRoleService.add(new UserRole("ROLE_ADMIN"));
        userRoleService.add(new UserRole("ROLE_USER"));
    }

    private void sportsData() {
        String allSports[] = {"футбол", "волейбол", "бадминтон", "хоккей",
                "городки", "теннси", "гольф", "баскетбол", "шахматы",
                "керлинг", "хоккей на траве", "хоккей с мячом", "литрбол", "нарды"};
        for (String s : allSports) {
            sportService.add(new Sport(s));
        }
    }
}
