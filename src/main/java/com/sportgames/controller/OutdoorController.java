package com.sportgames.controller;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class OutdoorController {
    private final PlaygroundService pgService;

    private final SportEventService seService;

    @Autowired
    public OutdoorController(PlaygroundService pgService, SportEventService seService) {
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
