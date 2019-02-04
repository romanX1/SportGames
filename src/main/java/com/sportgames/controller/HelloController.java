package com.sportgames.controller;

import com.sportgames.dao.PlaygroundDAO;
import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import com.sportgames.service.SportService;
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
    private PlaygroundService playgroundService ;
    @Autowired
    private SportService sportService ;
    @Autowired
    private SportEventService sportEventService;


    @GetMapping("/")
    public String userPage(){
        return "index";
    }


//    @PostMapping("/addGround") //возможно не нужен
//    public void addGround(HttpServletRequest req){
//        playgroundService.add(new Playground((String) req.getAttribute("newAddress")));
//    }


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

    @GetMapping("/sportevents")
    public ModelAndView events(){
        return eventsByTime("");
    }

    @GetMapping("/sportevents/{time}")
    public ModelAndView eventsByTime(@PathVariable String time){
        List<SportEvent> sportEvents;
        if (time.isEmpty()) {
            sportEvents = sportEventService.getAll();
        } else {
            sportEvents = null;
            //sportEvents = playgroundService.getPlaygroundBySportType(time); //нужно допилить
        }
        ModelAndView modelAndView = new ModelAndView("sportevents");
        modelAndView.addObject("sportevents", sportEvents);
        //modelAndView.addObject("sports", sportService.getAll() );

        return modelAndView;
    }
//    @RequestMapping(value = { "/groundList" }, method = RequestMethod.GET)
//    public String groundList(Model model) {
//
//        grounds.add(new Playground("address"));
//        grounds.add(new Playground("address111"));
//        grounds.add(new Playground("address222"));
//
//        model.addAttribute("grounds", grounds);
//
//        return "playgrounds";
//    }



}
