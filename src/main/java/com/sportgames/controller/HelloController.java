package com.sportgames.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sportgames.model.*;
import com.sportgames.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


@Controller
public class HelloController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private PlaygroundService playgroundService;
    @Autowired
    private SportService sportService;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/event/{eventId}")
    public ModelAndView eventPage(@PathVariable Long eventId) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        SportEvent sportEvent = eventService.findById(eventId);
        ModelAndView modelAndView = new ModelAndView("event");
        modelAndView.addObject("sportEvent", sportEvent);
        modelAndView.addObject("user", auth.getName());
        modelAndView.addObject("messages", messageService.findBySportEventId(eventId));
                                                            //2/15/19 11:46 AM
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/d/YY HH:mm");
        modelAndView.addObject("formatter", formatter);
        modelAndView.addObject("eventDateStart", sportEvent.getTimeStart().format(DateTimeFormatter.ofPattern("d MMMM yyyy с HH:mm", new Locale("ru"))));
        modelAndView.addObject("eventDateEnd", sportEvent.getTimeEnd().format(DateTimeFormatter.ofPattern("по HH:mm", new Locale("ru"))));
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);


        return "login";
    }

    @GetMapping("/addGround")
    public String addGround(Model model) {
        //model.addAttribute("Playground", new Playground ());
        return "addground";
    }

    @PostMapping("/addGround")
    public void addGround(HttpServletRequest req) {

        playgroundService.add(new Playground((String) req.getAttribute("newAddress")));
    }

    @GetMapping("/addnewevent")
    public ModelAndView addneweventMenu(@RequestParam(required = false) Long id, @RequestParam(required = false) String type) {
        ModelAndView modelAndView = new ModelAndView("addnewevent");
        if(id==null||type==null) {

            modelAndView.addObject("playgrounds", playgroundService.getAll());
            modelAndView.addObject("sports", sportService.getAll());
        } else {
            modelAndView.addObject("playgrounds", playgroundService.findById(id));
            modelAndView.addObject("sports", sportService.findByType(type));
        }
        return modelAndView;
    }

    @PostMapping("/addnewevent")
    public String addNewEvent(@RequestParam("selectSport") Long sportId,
                              @RequestParam("selectGround") Long groundId,
                              @RequestParam("data") String data,
                              @RequestParam("timeStart") String timeStart,
                              @RequestParam("timeEnd") String timeEnd) {
        String startTime = data + " " + timeStart;
        String endTime = data + " " + timeEnd;
        Playground playground = playgroundService.findById(groundId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataTimeStart = LocalDateTime.parse(startTime, formatter);
        LocalDateTime dataTimeEnd = LocalDateTime.parse(endTime, formatter);
        Sport sport = sportService.findById(sportId);
        eventService.add(new SportEvent(sport, dataTimeEnd, dataTimeStart, playground));
        return "redirect:/playgrounds";
    }

    @GetMapping("/playgrounds")
    public ModelAndView playGroundsByType() {
        List<Playground> playgrounds;
        playgrounds = playgroundService.getAll();
        ModelAndView modelAndView = new ModelAndView("playgrounds");
        modelAndView.addObject("kremlin", playgroundService.findByName("Кремль"));
        modelAndView.addObject("grounds", playgrounds);
        modelAndView.addObject("sports", sportService.getAll());

        return modelAndView;
    }

    @GetMapping("/adminplaygrounds")
    public ModelAndView adminPlayGroundsByType() {
        List<Playground> playgrounds;
        playgrounds = playgroundService.getAll();
        ModelAndView modelAndView = new ModelAndView("adminplaygrounds");
        modelAndView.addObject("kremlin", playgroundService.findByName("Кремль"));
        modelAndView.addObject("grounds", playgrounds);
        modelAndView.addObject("sports", sportService.getAll());

        return modelAndView;
    }

    @GetMapping("/sportevents")
    public ModelAndView events() {
        return eventsByTime("");
    }

    @GetMapping("/sportevents/{time}")
    public ModelAndView eventsByTime(@PathVariable String time) {
        List<SportEvent> sportEvents;
        if (time.isEmpty()) {
            sportEvents = eventService.getAll();
        } else {
            sportEvents = null;
            //sportEvents = playgroundService.getPlaygroundBySportType(time); //нужно допилить
        }
        ModelAndView modelAndView = new ModelAndView("sportevents");
        modelAndView.addObject("sports", sportService.getAll());
        modelAndView.addObject("sportevents", sportEvents);
        //modelAndView.addObject("sports", sportService.getAll() );

        return modelAndView;
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("name") String userName,
                          @RequestParam("email") String login,
                          @RequestParam("password2") String password) {
        System.out.println(userName);
        System.out.println(login);
        System.out.println(password);
        UserRole role = userRoleService.findByAuthority("ROLE_USER");
        Set<UserRole> auth = new HashSet<>();
        auth.add(role);
        userService.add(new User(userName, login, userService.encodePassword(password), auth));
        return "/login";
    }

    @GetMapping("/stat")
    public ModelAndView showStat() {
        ModelAndView modelAndView = new ModelAndView("stat");
        modelAndView.addObject("famousPG", playgroundService.findFamousPlayground());
        modelAndView.addObject("famousSE", eventService.findFamousSE());
        modelAndView.addObject("famousUser", userService.findFamousUser());
        modelAndView.addObject("countPG", playgroundService.countPG());
        modelAndView.addObject("countSE", eventService.countSE());
        modelAndView.addObject("countUsers", userService.countUsers());
        modelAndView.addObject("famousSport", eventService.getFamousSport());
        modelAndView.addObject("famousSportInMonth", eventService.getFamousSportInMonth());
        modelAndView.addObject("Date", LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("ru"))));
        modelAndView.addObject("countSEInMonth", eventService.countSEInMonth());


        return modelAndView;
    }

}