package com.blz.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to JDBC Database");
        //step 1
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not loaded");
        }
        //step 2
        String JDBCURL = "jdbc:mysql://localhost:3306/emp_payroll_service";
        try {
            DriverManager.getConnection(JDBCURL, "root", "root");
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Connection not established");
        }
    }
}
