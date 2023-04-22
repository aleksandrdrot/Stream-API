package com.drot.streamapi;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsService {

    private EmployeeService employeeList;

    public DepartmentsService(EmployeeService employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> personId(int departmentNumber) {
        return employeeList.employee.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> allPerson() {
        return employeeList.employee.stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .collect(Collectors.toList());
    }

    public Employee personMinSalary(int departmentNumber) {
        return employeeList.employee.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }

    public Employee personMaxSalary(int departmentNumber) {
        return employeeList.employee.stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }
}


