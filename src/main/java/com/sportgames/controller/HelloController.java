package com.sportgames.controller;

import com.sportgames.model.Playground;
import com.sportgames.model.Sport;
import com.sportgames.model.SportEvent;
import com.sportgames.service.PlaygroundService;
import com.sportgames.service.EventService;
import com.sportgames.service.SportService;
import com.sportgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private PlaygroundService playgroundService ;
    @Autowired
    private SportService sportService ;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String userPage(){
        return "index";
    }

    @GetMapping("/event")
    public ModelAndView eventPage(HttpServletRequest req){
        long id = 15L;
        SportEvent sportEvent = eventService.findById(id);
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

    @GetMapping("/addnewevent")
    public ModelAndView addneweventMenu(){
        ModelAndView modelAndView = new ModelAndView("addnewevent");

        modelAndView.addObject("playgrounds", playgroundService.getAll());
        modelAndView.addObject("sports", sportService.getAll());

        return modelAndView;
    }

    @PostMapping("/addnewevent")
    public String addNewEvent(@RequestParam("selectSport") Long sportId,@RequestParam("selectGround") Long groundId,
                            @RequestParam("data") String data,
                            @RequestParam("timeStart") String timeStart,
                            @RequestParam("timeEnd") String timeEnd){
        String startTime = data + " " + timeStart;
        String endTime = data + " " + timeEnd;
        Playground playground = playgroundService.findById(groundId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataTimeStart = LocalDateTime.parse(startTime,formatter);
        LocalDateTime dataTimeEnd = LocalDateTime.parse(endTime,formatter);
        Sport sport = sportService.findById(sportId);
        eventService.add(new SportEvent(sport,dataTimeEnd,dataTimeStart,playground));
        return "redirect:/playgrounds";
    }

    @GetMapping("/playgrounds")
    public ModelAndView playGroundsByType(){
        List<Playground> playgrounds;
            playgrounds = playgroundService.getAll();
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
            sportEvents = eventService.getAll();
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