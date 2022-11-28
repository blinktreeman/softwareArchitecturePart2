# softwareArchitecture Part_2

### Абстрактный класс [Employee.java](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/employees/Employee.java)

Задан с полями name, surname, salary. 
Выполнен конструктор с тремя параметрами

```java
public abstract class Employee {
    protected String name;
    protected String surname;
    protected double salary;

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }
    ...
```
Для расчета ежемесячной зарплаты абстрактный метод 
```java
abstract double calculateSalary();
```
Для вывода в классе метод toString(). 
Для потомков не делал переопределения метода, 
потомки используют метод со своей реализацией calculateSalary()
```java
@Override
public String toString() {
    return this.getClass().getSimpleName() + " {" +
        " name: " + name +
        ", surname: " + surname +
        ", salary_per_month: " + this.calculateSalary() +
        '}';
}
```
### Классы-производные [Freelancer.java](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/employees/Freelancer.java) и [Worker.java](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/employees/Worker.java)
У каждого реализован собственный метод расчета ежемесячной оплаты

Freelancer.java
```java
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
```
Worker.java
```java
public class Worker extends Employee {

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
```
### Фабрика [EmployeesFactory.java](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/factory/EmployeesFactory.java)
Какую реализацию Employee возвратить решаем по значению salary.
Считаем, что часовая ставка фрилансера ограничена 1000 руб.
```java
public class EmployeesFactory {
    private final double MAXIMAL_FREELANCER_PER_HOUR_SALARY = 1000;

    public Employee generateEmployee(String name, String surname, double salary) {
        if (salary < MAXIMAL_FREELANCER_PER_HOUR_SALARY) {
            return new Freelancer(name, surname, salary);
        }
        return new Worker(name, surname, salary);
    }
}
```
### Список работников [EmployeesList.java](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/employees/EmployeesList.java)
Singleton-класс с private списком сотрудников
```java
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
```
### App [main](https://github.com/blinktreeman/softwareArchitecturePart2/blob/master/src/main/java/ru/bcomms/App.java) метод 
```java
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

/*
    Output:
    Freelancer { name: Ivan, surname: Ivanov, salary_per_month: 88000.0}
    Freelancer { name: Pyotr, surname: Petrov, salary_per_month: 60500.0}
    Worker { name: Xenia, surname: Onatopp, salary_per_month: 70000.0}
    Worker { name: John, surname: Doe, salary_per_month: 100000.0}
*/
```
