package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.impl.PlaygroundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaygroundRestController {
    @Autowired
    private PlaygroundService playgroundService;

    @RequestMapping
    public List<Playground> playgrounds(@RequestParam(value="type") String type){
        List<Playground> playgrounds=new ArrayList<>();
        playgrounds=playgroundService.getPlaygroundBySportType(type);
        return playgrounds;
    }
}
