package com.loyalty.app.controllers;

import com.loyalty.app.models.Counter;
import com.loyalty.app.models.Event;
import com.loyalty.app.util.ClientUtil;
import com.loyalty.app.util.constants.GlobalVariables;
import com.loyalty.app.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.loyalty.app.util.constants.GlobalVariables.counters;

@Controller
@RequestMapping("/clients")
public class ClientsController {


    @RequestMapping(method = RequestMethod.GET)
    public String clients(ModelMap model) {
        List<String> clientsIDs = new ArrayList<>();
        for (Counter counter : counters) {
            if (!clientsIDs.contains(String.valueOf(counter.getClientID()))) {
                clientsIDs.add(String.valueOf(counter.getClientID()));
            }
        }

        model.addAttribute("clients", clientsIDs);
        return "clients";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String clientInf(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("counterAndEvents", ClientUtil.getCounterAndEventsByClientID((int) id));
        model.addAttribute("clientID", id);
        model.addAttribute("rules", ClientUtil.getRelevantRulesByClientID((int) id));
        return "client";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "single")
    public String clientGetBonusesSingle(@PathVariable("id") long id,
                                   @RequestParam(required = false, name = "clientID") String clientID,
                                   @RequestParam(required = false, name = "counterName") String counterName,
                                   @RequestParam(required = false, name = "event") String eventName,
                                   ModelMap model) {
        Event event = GlobalVariables.events.stream().filter(c -> c.getCounterName().equals(counterName) &&
                eventName.equals(c.getCounterName().concat(" - ").concat(String.valueOf(c.getLimit())))).findFirst().get();
        Counter counter = GlobalVariables.counters.stream().filter(c -> c.getName().equals(counterName) &&
               clientID.equals(String.valueOf(c.getClientID()))).findFirst().get();
        int bonuses = event.countBonuses(counter);

        GlobalVariables.counters.stream().filter(c -> c.getName().equals(counterName) &&
                clientID.equals(String.valueOf(c.getClientID()))).findFirst().get().setAmountOfSum(counter.getAmountOfSum());

        model.addAttribute("counterAndEvents", ClientUtil.getCounterAndEventsByClientID((int) id));
        model.addAttribute("bonuses", bonuses);
        model.addAttribute("clientID", id);
        model.addAttribute("rules", ClientUtil.getRelevantRulesByClientID((int) id));
        return "client";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "complicated")
    public String clientGetBonusesComplicated(@PathVariable("id") long id,
                                   @RequestParam(required = false, name = "ruleID") String ruleID,
                                   ModelMap model) {

        List<Counter> counters = ClientUtil.getCountersByID((int)id);
        int bonuses = GlobalVariables.rules.stream().filter(x->x.getId() == Integer.parseInt(ruleID)).findFirst().get().countBonuses(counters);
        model.addAttribute("counterAndEvents", ClientUtil.getCounterAndEventsByClientID((int) id));
        model.addAttribute("bonuses", bonuses);
        model.addAttribute("clientID", id);
        model.addAttribute("rules", ClientUtil.getRelevantRulesByClientID((int) id));
        return "client";
    }

}