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
            int r1 = (int)Math.random()*7+1;
            int r2 = (int)Math.random()*15;
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
            SportEvent se = new SportEvent();
            Playground pg = playgroundService.get((long) (Math.random() * 3) + 1);
            List<Sport> pgsports = new ArrayList<>(pg.getSports());
            se.setSport(pgsports.get(i%(pgsports.size())));
            se.setPlayground(pg);
            se.setUsers(new HashSet<>(userService.getAll().subList(Math.min(or1, or2), Math.max(or1, or2))));

            //EVENTS DATE AND TIME
            LocalDateTime ldStart=LocalDateTime.of(2019, (int)Math.random()+2, (int)Math.random()*27+1,(int)Math.random()*10+10, (int)Math.random()*60);
            LocalDateTime ldEnd=ldStart.plusMinutes((int)Math.random()*75+30);
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

        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName("user" + i * Math.random());
            userService.add(user);
        }
    }


    private void sportsData() {
        String allSports[] = {"футбол", "волейбол", "бадминтон", "хоккей",
                "городки", "теннси", "гольф", "баскетбол", "шахматы",
                "керлинг", "хоккей на траве", "хоккей с мячом", "литрбол", "нарды"};
        for (String s : allSports) {
            sportService.add(new Sport(s, 1800000+(long)Math.random()*3600000));
        }
    }
}
