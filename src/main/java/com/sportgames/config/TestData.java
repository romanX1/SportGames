package com.sportgames.config;


import com.sportgames.model.*;
import com.sportgames.service.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class TestData {

    @Autowired
    private PlaygroundService playgroundService;
    @Autowired
    private UserService userService;
    @Autowired
    private SportService sportService;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserRoleService userRoleService;

    public void initData() {
        usersData();

        Faker faker = new Faker(new Locale("ru"));
        List<Sport> allSports = sportService.getAll();

        Playground pgk=new Playground("defaultPG");
        pgk.setCoordinates(new Point(59.76565f, 30.42358f));
        int sk1 = (int) (Math.random() * 7);
        int sk2 = (int) (Math.random() * 7) + 7;
        Set<Sport> ksports = new HashSet<>(allSports.subList(Math.min(sk1, sk2), Math.max(sk1, sk2)));
        pgk.setSports(ksports);
        playgroundService.add(pgk);

        for (int i = 0; i < 30; i++) {
            Playground pg = new Playground(faker.address().streetAddress());
            float dX = (float)(0.4 * Math.random()) + 59.7f;
            float dY = (float)(0.33 * Math.random()) + 30.18f;
            pg.setCoordinates(new Point(dX, dY));
            int s1 = (int) (Math.random() * 7);
            int s2 = (int) (Math.random() * 7) + 7;
            Set<Sport> sports = new HashSet<>(allSports.subList(Math.min(s1, s2), Math.max(s1, s2)));
            pg.setSports(sports);

            playgroundService.add(pg);
        }

        List<User> users;
        users = userService.getAll();

        for (int i = 0; i < 100; i++) {
            int s1 = (int) (Math.random() * 30);
            int s2 = (int) (Math.random() * 29 + 1);
            SportEvent spe = new SportEvent();
            spe.setUsers(new HashSet<>(users.subList(Math.min(s1, s2), Math.max(s1, s2))));

            Playground pg = playgroundService.findById((long) (i % (int) (Math.random() * 28 + 1) + 1));
            spe.setPlayground(pg);
            List<Sport> pgsports = new ArrayList<>(pg.getSports());
            int g = pgsports.size() != 1 ? i % (pgsports.size() - 1) : 0;
            spe.setSport(pgsports.get(g));
            LocalDateTime ldStart = LocalDateTime.of(2019,  2, (int) (Math.random() * 13 + 15), (int) (Math.random() * 23), (int) (Math.random() * 59));
            LocalDateTime ldEnd = ldStart.plusMinutes((int) (Math.random() * 75 + 30));
            spe.setTimeStart(ldStart);
            spe.setTimeEnd(ldEnd);
            eventService.add(spe);
        }
    }

    private void usersData() {
        userRoleData();
        Faker faker = new Faker(new Locale("ru"));


        for (int i = 0; i < 300; i++) {
            User user = new User();
            user.setName(faker.name().fullName());
            user.setLogin("test" + i);
            user.setPassword(userService.encodePassword("123"));
            user.setAuthorities(new HashSet<>(randomAutorities()));
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


}
