package com.blz.jdbc;


public class EmployeePayrollService {
    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        //service.retrieveData();
        service.updateSalary("Terisa", 1000000);
    }

    private void updateSalary(String name, int salary) {
        repository.updateSalaryUsingPreparedStatement(name.toLowerCase(),salary);
       // repository.updateSalary(name, salary);
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }
}
