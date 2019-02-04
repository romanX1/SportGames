package com.sportgames.config;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import com.sportgames.service.SportService;
import com.sportgames.service.UserService;
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

    public void initData() {
        Random random = new Random();
        //USERS
        usersData();
        //SPORTS
        sportsData();
        //PLAYGROUNDS
        String[] playgrounds = playgroundsData();


        for (String p : playgrounds) {
            int r1 = Math.abs(random.nextInt() % 7);
            int r2 = Math.abs(random.nextInt() % 15);
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
        int or2 = randomer % 31;

        //EVENTS
        for (int i = 0; i < 50; i++) {
            List<User> userList = new ArrayList<>();
            SportEvent se = new SportEvent();
            Playground pg = playgroundService.get((long) (Math.random() * 3) + 1);
            List<Sport> pgsports = new ArrayList<>(pg.getSports());
            se.setSport(pgsports.get(random.nextInt(pgsports.size())));
            se.setPlayground(pg);
            int randomK = (int) (Math.random() * 25);

            for (int k = 0; k < randomK; k++) {
                userList.add(userService.findById((long) ((Math.random() * 28) + 1)));
            }

            se.setUsers(new HashSet<>(userList));

            se.setTimeStart(LocalDateTime.of(2019, (int) (Math.random() * 11) + 1,(int) (Math.random() * 25) + 1,
                    (int) (Math.random() * 23),(int) (Math.random() * 59)));
            se.setTimeEnd(LocalDateTime.of(2019, (int) (Math.random() * 11) + 1,(int) (Math.random() * 25) + 1,
                    (int) (Math.random() * 23),(int) (Math.random() * 59)));
            sportEventService.add(se);
        }


    }

    private String[] playgroundsData() {
        String[] s = {"Кремль", "Ледовый", "Олимпийский", "Дворец Пионеров"};
        return s;
    }

    private void usersData() {

        for (int i = 1; i < 30; i++) {
            User user = new User();
            user.setName("user" + i);
            userService.add(user);
        }
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
