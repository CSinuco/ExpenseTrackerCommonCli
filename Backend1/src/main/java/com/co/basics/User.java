package com.co.basics;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Expenses> expenses = new ArrayList<Expenses>();

    public void addExpense(String description, double ammount){
        Expenses expenses1 = new Expenses(description, ammount);
        expenses.add(expenses1);
        System.out.println("Gasto con id "+expenses1.id + " a sido agregado");
    }
    public void mostrarExpenses(){
        for(Object e: expenses){
            System.out.println(e.toString());
        }
    }
    public void deleteExpenses(int id){
        for (int i = 0; i < expenses.size() ; i++) {
            Expenses a = expenses.get(i);
            if (a.getId()==id){
                expenses.remove(a);
            }

        }
    }
    public double getSummaryExpenses(){
        double total = 0;
        for (int i = 0; i < expenses.size() ; i++) {
            Expenses a = expenses.get(i);
            total = total + a.getAmount();
        }
        return total;
    }
}
