package com.sportgames.config;

import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class AddSportsToBase {

    @Autowired
    private SportService sportService;

    Set<String> sportTypes;

    public void initSports() {
        sportTypes = new TreeSet<>(Arrays.asList(getSportTypes()));

        for (String str : sportTypes) {
            Sport sport = new Sport(str);
            sport.setMaxPlayers(25);
            sportService.add(sport);
        }

    }

    public String[] getSportTypes() {
        String[] sportsValues  = new String[]{

                "Айкидо",
                "Армрестлинг",
                "Бадминтон",
                "Баскетбол",
                "Бокс",
                "Борьба",
                "Велосипедный спорт",
                "Волейбол",
                "Гимнастика",
                "Городки",
                "Дартс",
                "Единоборства‎",
                "Легкая атлетика",
                "Настольный теннис",
                "Регби",
                "Футбол",
                "Хоккей с мячом",
                "Хоккей с шайбой",
                "Шахматы",
                "Шашки",
        };
        return sportsValues;
    }


}
