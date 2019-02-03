package com.sportgames.config;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.dao.SportDAO;
import com.sportgames.dao.SportEventDAO;
import com.sportgames.dao.UserDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import com.sportgames.service.SportService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;



public class TestData {

    @Autowired
    private PlaygroundService playgroundDAO;
    @Autowired
    private UserService userDAO;
    @Autowired
    private SportService sportDAO;
    @Autowired
    private SportEventService sportEventDAO;

    public void initData(){
        HashSet<User> users=new HashSet<>();
        User user=new User();
        user.setName("igrok");
        users.add(user);
        userDAO.add(user);

        Sport soccer=new Sport();
        Sport volleyball=new Sport();
        Sport badminton=new Sport();
        soccer.setType("soccer");
        volleyball.setType("volleyball");
        badminton.setType("badminton");
        sportDAO.add(soccer);
        sportDAO.add(volleyball);
        sportDAO.add(badminton);

        Playground kremlin=new Playground("kremlin");
        Set<Sport> kremlinSports=new HashSet<>();
        kremlinSports.add(soccer);
        kremlinSports.add(volleyball);
        kremlinSports.add(badminton);
        kremlin.setSports(kremlinSports);
        playgroundDAO.add(kremlin);

        SportEvent soccerGame=new SportEvent();
        soccerGame.setSport(soccer);
        soccerGame.setUsers(users);
        soccerGame.setTimeEvent("anytime");

        SportEvent volleyballGame=new SportEvent();
        volleyballGame.setSport(volleyball);
        volleyballGame.setUsers(users);
        volleyballGame.setTimeEvent("never");
        volleyballGame.setPlayground(kremlin);


        sportEventDAO.add(volleyballGame);
        sportEventDAO.add(soccerGame);
    }
}
