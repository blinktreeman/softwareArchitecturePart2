package ru.bcomms.employees;

public abstract class Employee {
    protected String name;
    protected String surname;
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                " name: " + name +
                ", surname: " + surname +
                ", salary_per_month: " + this.calculateSalary() +
                '}';
    }
}
