package com.loyalty.app.controllers;

import com.loyalty.app.models.Event;
import com.loyalty.app.util.constants.GlobalVariables;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

import static com.loyalty.app.util.constants.GlobalVariables.events;
import static com.loyalty.app.util.constants.GlobalVariables.types;

@Controller
@RequestMapping("/events")
public class EventsController {


    @RequestMapping(method = RequestMethod.GET)
    public String events(ModelMap model) {
        model.addAttribute("types", types);
        model.addAttribute("events", events);
        return "events";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addEvent(@RequestParam(required = false, name = "type") String type,
                           @RequestParam(required = false, name = "limit") String limit,
                           @RequestParam(required = false, name = "condition") String condition,
                           ModelMap model) {

        int intLimit = Integer.parseInt(limit);
        int intCondition = Integer.parseInt(condition);

        intCondition = intLimit > intCondition ? intLimit : intCondition;

        List<Event> globalEvents = GlobalVariables.events;
        Event addedEvent = new Event(type, intLimit, intCondition);
        if (globalEvents.stream()
                .noneMatch(x -> x.getCounterName()
                        .equals(addedEvent.getCounterName()) && x.getLimit() == addedEvent.getLimit() && x.getCondition() == addedEvent.getCondition())) {
            GlobalVariables.events.add(addedEvent);
        }
        model.addAttribute("types", types);
        model.addAttribute("events", GlobalVariables.events);
        return "events";
    }
}
