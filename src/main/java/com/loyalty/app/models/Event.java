package com.loyalty.app.models;

public class Event {

    private String counterName;
    private int limit;
    private int condition;
    private boolean done;

    public Event(String counterName, int limit, int condition) {
        this.counterName = counterName;
        this.limit = limit;
        this.condition = condition;
        this.done = false;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int countBonuses(Counter counter) {
        int bonuses = 0;
        int sum = counter.getAmountOfSum();
        if (sum >= this.limit) {
            bonuses = (sum - (sum % this.limit)) / this.limit;
            counter.setAmountOfSum(sum % this.limit);
        }
        return bonuses;
    }
}
