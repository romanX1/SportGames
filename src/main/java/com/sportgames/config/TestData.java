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
    private SportEventService sportEventService;
    @Autowired
    private UserRoleService userRoleService;

    public void initData() {
        usersData();
        Faker faker = new Faker(new Locale("ru"));
        List<Sport> allSports = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Sport sport = new Sport(faker.esports().game());
            sportService.add(sport);
        }
        allSports = sportService.getAll();
        Playground pgk=new Playground("Кремль");
        int sk1 = (int) (Math.random() * 15);
        int sk2 = (int) (Math.random() * 14) + 15;
        Set<Sport> ksports = new HashSet<>(allSports.subList(Math.min(sk1, sk2), Math.max(sk1, sk2)));
        pgk.setSports(ksports);
        playgroundService.add(pgk);

        for (int i = 0; i < 30; i++) {
            Playground pg = new Playground(faker.address().streetAddress());


            int s1 = (int) (Math.random() * 15);
            int s2 = (int) (Math.random() * 14) + 15;
            Set<Sport> sports = new HashSet<>(allSports.subList(Math.min(s1, s2), Math.max(s1, s2)));
            pg.setSports(sports);

            playgroundService.add(pg);
        }

        List<User> users;
        users = userService.getAll();

        for (int i = 0; i < 100; i++) {
            int s1 = (int) (Math.random() * 300);
            int s2 = (int) (Math.random() * 298 + 1);
            SportEvent spe = new SportEvent();
            spe.setUsers(new HashSet<>(users.subList(Math.min(s1, s2), Math.max(s1, s2))));
            Playground pg = playgroundService.findById((long) (i % (int) (Math.random() * 28 + 1) + 1));
            spe.setPlayground(pg);
            List<Sport> pgsports = new ArrayList<>(pg.getSports());
            int g = pgsports.size() != 1 ? i % (pgsports.size() - 1) : 0;
            spe.setSport(pgsports.get(g));
            LocalDateTime ldStart = LocalDateTime.of(2019, (int) (Math.random() + 2), (int) (Math.random() * 27 + 1), (int) (Math.random() * 10 + 10), (int) (Math.random() * 59));
            LocalDateTime ldEnd = ldStart.plusMinutes((int) (Math.random() * 75 + 30));
            spe.setTimeStart(ldStart);
            spe.setTimeEnd(ldEnd);
            sportEventService.add(spe);
        }
    }

    private void usersData() {
        userRoleData();

        for (int i = 0; i < 300; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setLogin("user" + i);
            user.setPassword(userService.encodePassword("user" + i));
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
