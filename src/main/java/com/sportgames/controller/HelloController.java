package com.sportgames.controller;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class HelloController {

    private  List<Playground> grounds = new ArrayList<>();

    @GetMapping("/")
    public String userPage(){
        return "index";
    }

    @GetMapping("/addGround")
    public String addGround(){
        return "addground";
    }

    @RequestMapping(value = { "/groundList" }, method = RequestMethod.GET)
    public String groundList(Model model) {

        grounds.add(new Playground("address"));
        grounds.add(new Playground("address111"));
        grounds.add(new Playground("address222"));

        model.addAttribute("grounds", grounds);

        return "playgrounds";
    }



}
