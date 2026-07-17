package com.co.basics;

public class Expenses {
    private String description;
    private double amount;
    static int id = 0;
    Expenses(String description, double amount){
        this.description = description;
        this.amount = amount;
        id++;
    }

    public static int getId() {
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
