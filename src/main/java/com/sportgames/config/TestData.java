package com.sportgames.config;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.dao.SportDAO;
import com.sportgames.dao.SportEventDAO;
import com.sportgames.dao.UserDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;



public class TestData {

    @Autowired
    PlaygroundDAO playgroundDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    SportDAO sportDAO;
    @Autowired
    SportEventDAO sportEventDAO;

    public void initData(){

        Playground kremlin=new Playground("kremlin");
        playgroundDAO.add(kremlin);

        Sport soccer=new Sport();
        Sport volleyball=new Sport();
        Sport badminton=new Sport();
        soccer.setType("soccer");
        volleyball.setType("volleyball");
        badminton.setType("badminton");
        sportDAO.add(soccer);
        sportDAO.add(volleyball);
        sportDAO.add(badminton);

        Set<Sport> kremlinSports=new HashSet<>();
        kremlinSports.add(soccer);
        kremlinSports.add(volleyball);
        kremlinSports.add(badminton);
        kremlin.setSports(kremlinSports);

        HashSet<User> users=new HashSet<>();
        User user=new User();
        user.setName("igrok");
        users.add(user);
        userDAO.add(user);

        SportEvent soccerGame=new SportEvent();
        soccerGame.setSport(soccer);
        soccerGame.setUsers(users);
        soccerGame.setTimeEvent("anytime");

        SportEvent volleyballGame=new SportEvent();
        volleyballGame.setSport(volleyball);
        volleyballGame.setUsers(users);
        volleyballGame.setTimeEvent("never");

        Set<SportEvent> kremlinEvents=new HashSet<>();
        kremlinEvents.add(soccerGame);
        kremlinEvents.add(volleyballGame);

        sportEventDAO.add(volleyballGame);
        sportEventDAO.add(soccerGame);
    }
}
