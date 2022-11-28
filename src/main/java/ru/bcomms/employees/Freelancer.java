package ru.bcomms.employees;

public class Freelancer extends Employee{

    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    private int WORK_DAYS = 22;
    private int WORK_HOURS_PER_DAY = 5;

    @Override
    public double calculateSalary() {
        return salary * WORK_DAYS * WORK_HOURS_PER_DAY;
    }
}
