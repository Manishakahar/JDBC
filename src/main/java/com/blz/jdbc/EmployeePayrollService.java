package com.blz.jdbc;

import java.time.LocalDate;


public class EmployeePayrollService {
    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.retrieveDataJoinedDate(LocalDate.parse("2010-02-10"));
        //service.retrieveData();
        service.updateSalary("Terisa", 1000000);
    }

    private void retrieveDataJoinedDate(LocalDate date) {
        System.out.println(repository.retrieveDataJoinedDate(date));
    }

    private void updateSalary(String name, int salary) {
        repository.updateSalaryUsingPreparedStatement(name.toLowerCase(),salary);
       // repository.updateSalary(name, salary);
      
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }
}
