package com.co.basics.service;

import com.co.basics.model.Expense;
import com.co.basics.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    List<Expense> expenses = new ArrayList<>();
    ExpenseRepository repository = new ExpenseRepository();
    public void addExpense(String description, double ammount){

        Expense expenses1 = new Expense(description, ammount);
        expenses.add(expenses1);
        System.out.println("Gasto con id "+ expenses1.getId() + " a sido agregado");
        repository.save(expenses1);
    }
    public void mostrarExpenses(){
        repository.getAll();
    }
    public void deleteExpenses(int id){
        repository.delete(id);
    }
    public void getSummaryExpenses() {
        repository.getResume();
    }
}
