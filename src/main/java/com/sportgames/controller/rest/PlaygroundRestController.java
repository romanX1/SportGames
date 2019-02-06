package com.sportgames.controller.rest;

import com.sportgames.model.Playground;
import com.sportgames.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaygroundRestController {
    @Autowired
    private PlaygroundService playgroundService;

    @PostMapping("/playgroundRest")
    public ResponseEntity<List<Playground>> playgrounds(@RequestParam(value="type") String type){
        List<Playground> playgrounds=new ArrayList<>();
        playgrounds=playgroundService.getPlaygroundBySportType(type);
        return ResponseEntity.ok(playgrounds);
    }
}
