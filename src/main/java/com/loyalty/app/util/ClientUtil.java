package com.loyalty.app.util;

import com.loyalty.app.models.Counter;
import com.loyalty.app.models.Event;
import com.loyalty.app.models.Rule;
import com.loyalty.app.util.constants.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

import static com.loyalty.app.util.constants.GlobalVariables.counters;

public class ClientUtil {

    public static List<Pair<Counter, List<Event>>> getCounterAndEventsByClientID(int id) {
        Object[] existedCounters
                = counters.stream().filter(c -> c.getClientID() == id).toArray();
        List<Counter> counters1 = new ArrayList<>();
        for (int i = 0; i < existedCounters.length; i++) {
            counters1.add((Counter) existedCounters[i]);
        }

        List<Event> globalVariablesEvents = GlobalVariables.events;
        //TODO тут counter сопоставляются с соответствующими event
        List<Pair<Counter, List<Event>>> counterAndEvents = new ArrayList<>();
        for (int i = 0; i < counters1.size(); i++) {
            List<Event> exEv = new ArrayList<>();
            for (int z = 0; z < globalVariablesEvents.size(); z++) {
                if (counters1.get(i).getName().contains(globalVariablesEvents.get(z).getCounterName())
                        && (counters1.get(i).getAmountOfSum() >= globalVariablesEvents.get(z).getCondition())) {
                    exEv.add(globalVariablesEvents.get(z));
                }
            }
            counterAndEvents.add(new Pair<>(counters1.get(i), exEv));
        }
        return counterAndEvents;
    }

    public static List<Counter> getCountersByID(int id) {
        Object[] existedCounters
                = counters.stream().filter(c -> c.getClientID() == id).toArray();
        List<Counter> counters1 = new ArrayList<>();
        for (int i = 0; i < existedCounters.length; i++) {
            counters1.add((Counter) existedCounters[i]);
        }
        return counters1;
    }

    public static List<Rule> getRelevantRulesByClientID(int id) {
        List<Counter> counters = getCountersByID(id);
        List<Rule> rules = new ArrayList<>();

        for (int i = 0; i < GlobalVariables.rules.size(); i++) {
            Rule rule = GlobalVariables.rules.get(i);
            List<Event> eventsFromRules = rule.getCoeffsAndEvents().getSecondElement();

            boolean check = false;

            //проверка входит ли подмножество событий правила в множество счетчиков
            for (int j = 0; j < eventsFromRules.size(); j++) {
                int finalJ = j;
                check = counters.stream().anyMatch(x -> x.getName().equals(eventsFromRules.get(finalJ).getCounterName())
                        && (x.getAmountOfSum() >= eventsFromRules.get(finalJ).getCondition()));
                if (!check) {
                    break;
                }
            }
            if (check) {
                rules.add(rule);
            }
        }

        return rules;
    }
}
