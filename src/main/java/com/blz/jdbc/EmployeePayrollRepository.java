package com.blz.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {
    Connection connection;

    private Connection getConnection() {
        try {
            String JDBCURL = "jdbc:mysql://localhost:3306/emp_payroll_service";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBCURL, "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Driver is not loaded");
        }
        return connection;
    }

    public List<EmployeeInfo> retrieveData() {
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        try (Connection connection = getConnection()) {
            // Step 3
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from employee";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                EmployeeInfo info = new EmployeeInfo();
                info.setId(resultSet.getInt("id"));
                info.setName(resultSet.getString("name"));
                info.setGender(resultSet.getString("gender").charAt(0));
                info.setStartDate(resultSet.getDate("startDate"));
                info.setAddress(resultSet.getString("address"));
                info.setPhone(resultSet.getString("phone"));
                employeeInfos.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeInfos;
    }

    public void updateSalary(String name, int salary) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            // String sqlQuery = "update employee set salary= "+ salary+ "where name ="+name;
            String sqlQuery = String.format("update employee set salary= %d where name= '%s'", salary, name);
            int result = statement.executeUpdate(sqlQuery);
            if (result >= 1) {
                System.out.println("salary updated");
            }
        } catch (SQLException e) {

        }
    }

    public void updateSalaryUsingPreparedStatement(String name, int salary) {
      try (Connection connection = getConnection()){
          String query = "update employee set salary=? where name =?";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1,salary);
          preparedStatement.setString(2,name);
          int result = preparedStatement.executeUpdate();
          if (result >= 1) {
              System.out.println("salary updated");
          }

      } catch (SQLException e) {
      }
    }
}







