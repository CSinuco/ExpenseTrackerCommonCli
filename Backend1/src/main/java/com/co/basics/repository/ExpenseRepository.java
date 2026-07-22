package com.co.basics.repository;

import com.co.basics.DatabaseConnection;
import com.co.basics.model.Expense;

import javax.xml.transform.Result;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class ExpenseRepository {
    double total = 0;
    public void save(Expense expense) {
        String sql =
                "INSERT INTO expenses(description, amount) VALUES(?, ?)";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setString(1, expense.getDescription());
            ps.setDouble(2, expense.getAmount());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            }
        }
    public void getAll(){
        String sql = "SELECT * FROM expenses";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("id") + rs.getString("description") + "-$" + rs.getString("amount"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }


    }
    public void delete(int id){
        String sql = "DELETE FROM expenses WHERE id=?";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Gasto eliminado correctamente.");
            } else {
                System.out.println("No existe un gasto con ese ID.");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void getResume(){
        String sql = "SELECT amount from expenses";
        try(
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                double amount = rs.getDouble("amount");
               total = total + amount;
            }
            System.out.println(total);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}

