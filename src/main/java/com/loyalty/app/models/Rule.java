package com.loyalty.app.models;

import com.loyalty.app.util.Pair;

import java.io.Serializable;
import java.util.List;

public class Rule implements Serializable {
    private int id;
    private Pair<Integer, List<Event>> coeffsAndEvents;

    public Rule(Pair<Integer, List<Event>> coeffsAndEvents) {
        this.coeffsAndEvents = coeffsAndEvents;
    }

    public Rule(int id, Pair<Integer, List<Event>> coeffsAndEvents) {
        this.id = id;
        this.coeffsAndEvents = coeffsAndEvents;
    }

    public Rule() {
    }

    public Pair<Integer, List<Event>> getCoeffsAndEvents() {
        return coeffsAndEvents;
    }

    public void setCoeffsAndEvents(Pair<Integer, List<Event>> coeffsAndEvents) {
        this.coeffsAndEvents = coeffsAndEvents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int countBonuses(List<Counter> counters) {
        int bonuses = 0;
        List<Event> events = this.coeffsAndEvents.getSecondElement();

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            Counter counter = counters.stream().filter(x -> x.getName().equals(event.getOperationType())).findFirst().get();
            bonuses += event.countBonuses(counter);
        }

        return bonuses * this.coeffsAndEvents.getFirstElement();
    }

}
