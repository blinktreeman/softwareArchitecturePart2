package ru.bcomms.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesList {
    private static EmployeesList instance;
    private final List<Employee> employeesList = new ArrayList<>();

    public static EmployeesList getInstance() {
        if (instance == null) {
            instance = new EmployeesList();
        }
        return instance;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public boolean addEmployee(Employee employee) {
        return employeesList.add(employee);
    }

    public boolean removeEployee(Employee employee) {
        return employeesList.remove(employee);
    }
}
