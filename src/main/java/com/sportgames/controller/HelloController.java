package com.sportgames.controller;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.model.User;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import com.sportgames.service.SportService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class HelloController {

    @Autowired
    private SportEventService sportEventService;
    @Autowired
    private PlaygroundService playgroundService;
    @Autowired
    private SportService sportService;
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String userPage(){
        return "index";
    }

    @GetMapping("/event")
    public ModelAndView eventPage(){
        long id = 4L;
        SportEvent sportEvent = sportEventService.findById(id);
        ModelAndView modelAndView = new ModelAndView("event");
        modelAndView.addObject("sportEvent", sportEvent);
        return modelAndView;
    }

    @GetMapping("/addGround")
    public String addGround(Model model){
        //model.addAttribute("Playground", new Playground ());
        return "addground";
    }

    @PostMapping("/addGround")
    public void addGround(HttpServletRequest req){

        playgroundService.add(new Playground((String) req.getAttribute("newAddress")));
    }

    @GetMapping("/playgrounds")
    public ModelAndView playGrounds(){
        return playGroundsByType("");
    }

    @GetMapping("/playgrounds/{type}")
    public ModelAndView playGroundsByType(@PathVariable String type){
       List<Playground> playgrounds;
        if (type.isEmpty()) {
            playgrounds = playgroundService.getAll();
        } else {
            playgrounds = playgroundService.getPlaygroundBySportType(type);
        }
        ModelAndView modelAndView = new ModelAndView("playgrounds");
        modelAndView.addObject("grounds", playgrounds);
        modelAndView.addObject("sports", sportService.getAll() );

        return modelAndView;
    }


}
