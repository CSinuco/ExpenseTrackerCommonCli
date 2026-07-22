package com.co.basics.model;

public class Expense {
    private String description;
    private double amount;
    private int id = 0;
    public Expense(String description, double amount){
        this.description = description;
        this.amount = amount;
        id++;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Description: " + getDescription() + " | Amount: $" + getAmount();
    }

}
