package com.example.cafeteria.entity;

import java.util.Date;

public class Consumption {
    private String itemName;
    private double price;
    private Date timestamp;
    private String studentId;

    public Consumption(String itemName, double price, Date timestamp) {
        this.itemName = itemName;
        this.price = price;
        this.timestamp = timestamp;
    }

    // 게터랑 세터들~
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}