package com.sportgames.controller;

import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDateTime;
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
    public ModelAndView outdoor(@RequestParam(defaultValue = "1") Long id) {
        ModelAndView mav = new ModelAndView("outdoorpanel");
        Playground pg = pgService.findById(id);
        LocalDateTime ds=LocalDateTime.now();
//        .withHour(0).withMinute(0).withSecond(0);
        LocalDateTime de=LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        mav.addObject("events", seService.getActualEventsByPG(id, ds, de));
        mav.addObject("address", pg.getAddress());
        mav.addObject("formatter", DateTimeFormatter.ofPattern("H-m-s"));
        return mav;
    }
}
