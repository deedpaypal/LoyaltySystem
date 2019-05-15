package com.loyalty.app.models;


import java.io.Serializable;

public class Counter implements Serializable {

    private String name;

    private int clientID;

    private Document document;

    private String type;
    private int amountOfSum;

    public Counter(String name, Document document, String type, int amountOfSum) {
        this.name = name;
        this.clientID = document.getClientID();
        this.document = document;
        this.type = type;
        this.amountOfSum = amountOfSum;
    }

    public Counter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmountOfSum() {
        return amountOfSum;
    }

    public void setAmountOfSum(int amountOfSum) {
        this.amountOfSum = amountOfSum;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int countBonuses() {
        int bonuses = 0;
        int sum = amountOfSum;
        if (sum > 100) {
            bonuses = (sum - (sum % 100)) / 100;
            this.amountOfSum = (sum % 100);
        }
        return bonuses;
    }
}