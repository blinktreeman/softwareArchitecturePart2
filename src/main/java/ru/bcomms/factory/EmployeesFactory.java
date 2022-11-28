package ru.bcomms.factory;

import ru.bcomms.employees.Employee;
import ru.bcomms.employees.Freelancer;
import ru.bcomms.employees.Worker;

public class EmployeesFactory {
    private final double MAXIMAL_FREELANCER_PER_HOUR_SALARY = 1000;

    public Employee generateEmployee(String name, String surname, double salary) {
        if (salary < MAXIMAL_FREELANCER_PER_HOUR_SALARY) {
            return new Freelancer(name, surname, salary);
        }
        return new Worker(name, surname, salary);
    }
}
