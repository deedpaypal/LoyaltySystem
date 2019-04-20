package com.loyalty.app.models;

import java.util.Date;

public class Document {

    private int id;

    private Date date;

    private int atmID;

    private int clientID;

    private String type;

    private int sum;

    public Document(int id, Date date, int automatID, int clientID, String type, int sum) {
        this.id = id;
        this.date = date;
        this.atmID = automatID;
        this.clientID = clientID;
        this.type = type;
        this.sum = sum;
    }

    public Document(Date date, int automatID, int clientID, String type, int sum) {
        this.date = date;
        this.atmID = automatID;
        this.clientID = clientID;
        this.type = type;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAtmID() {
        return atmID;
    }

    public void setAtmID(int atmID) {
        this.atmID = atmID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
