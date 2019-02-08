package com.sportgames.controller;

import com.sportgames.service.PlaygroundService;
import com.sportgames.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.time.format.DateTimeFormatter;

@Controller
public class OutdoorController {
    private final PlaygroundService pgService;

    private final EventService seService;

    @Autowired
    public OutdoorController(PlaygroundService pgService, EventService seService) {
        this.pgService = pgService;
        this.seService = seService;
    }

    @GetMapping("/outdoorpanel")
    public ModelAndView outdoor(@RequestParam(defaultValue = "Кремль") String pgName){
        ModelAndView mav=new ModelAndView("outdoorpanel");
        String playground=pgName;
        mav.addObject("events", seService.getByPlayground(playground));
        mav.addObject("address", playground);
        mav.addObject("formatter", DateTimeFormatter.ofPattern("H-m-s"));
        return mav;
    }
}
