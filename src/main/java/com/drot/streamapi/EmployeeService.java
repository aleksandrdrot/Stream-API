package com.drot.streamapi;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    Employee employee;
    private final List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();

        add("Александр", "Пушкин", 12547, 2);
        add("Александр", "Гришин", 21535, 1);
        add("Максим", "Пупков", 12687, 3);
        add("Дима", "Перов", 13547, 2);
    }

    public Employee add(String firstName, String lastName, int salary, int department) {
        employee = new Employee(firstName, lastName, salary, department);
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> personId(int departmentNumber) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> allPerson() {
        return employeeList.stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .collect(Collectors.toList());
    }

    public Employee personMinSalary(int departmentNumber) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }

    public Employee personMaxSalary(int departmentNumber) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }
}


