package com.loyalty.app.models;

public class Event {

    private String operationType;
    private int limit;
    private int condition;
    private boolean done;

    public Event(String operationType, int limit, int condition) {
        this.operationType = operationType;
        this.limit = limit;
        this.condition = condition;
        this.done = false;
    }

    public Event() {
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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
