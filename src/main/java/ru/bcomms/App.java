package ru.bcomms;

import ru.bcomms.employees.EmployeesList;
import ru.bcomms.factory.EmployeesFactory;

public class App {
    public static void main(String[] args) {
        EmployeesList employeesList = new EmployeesList();
        EmployeesFactory employeesFactory = new EmployeesFactory();

        employeesList.addEmployee(employeesFactory.generateEmployee("Ivan", "Ivanov", 800));
        employeesList.addEmployee(employeesFactory.generateEmployee("Pyotr", "Petrov", 550));
        employeesList.addEmployee(employeesFactory.generateEmployee("Xenia", "Onatopp", 70000));
        employeesList.addEmployee(employeesFactory.generateEmployee("John", "Doe", 100000));

        employeesList.getEmployeesList().forEach(System.out::println);
    }
}
