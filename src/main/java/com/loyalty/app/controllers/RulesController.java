package com.loyalty.app.controllers;

import com.loyalty.app.models.Event;
import com.loyalty.app.models.Rule;
import com.loyalty.app.util.Pair;
import com.loyalty.app.util.constants.GlobalVariables;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/rules")
public class RulesController {


    @RequestMapping(method = RequestMethod.GET)
    public String rules(ModelMap model) {
        model.addAttribute("types", GlobalVariables.types);
        return "rules";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addRule(@RequestParam("type") List<String> types,
                          @RequestParam("limit") List<String> limits,
                          @RequestParam("condition") List<String> conditions,
                          @RequestParam(required = false, name = "coefficient") String coefficient,
                          ModelMap model) {

        int lastIndex = GlobalVariables.rules.size() == 0 ? 1 : (GlobalVariables.rules.get(GlobalVariables.rules.size() - 1).getId() + 1);
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            Event event = new Event(types.get(i), Integer.parseInt(limits.get(i)), Integer.parseInt(conditions.get(i)));
            if(events.stream().anyMatch(x -> x.getCounterName().equals(event.getCounterName()))){
                continue;
            }
            if (events.stream()
                    .noneMatch(x -> x.getCounterName()
                            .equals(event.getCounterName()) && x.getLimit() == event.getLimit() && x.getCondition() == event.getCondition())) {
                events.add(event);
            }
        }
        Rule rule = new Rule(lastIndex, new Pair<>(Integer.parseInt(coefficient), events));

        if (GlobalVariables.rules.stream()
                .noneMatch(x -> x.getCoeffsAndEvents().getFirstElement().equals(rule.getCoeffsAndEvents().getFirstElement())
                &&  x.getCoeffsAndEvents().getSecondElement().equals(rule.getCoeffsAndEvents().getSecondElement()))) {
            GlobalVariables.rules.add(rule);
        }

        model.addAttribute("types", GlobalVariables.types);
        model.addAttribute("rule", rule);

        return "rules";
    }

}
