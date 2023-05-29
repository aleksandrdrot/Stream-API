package com.drot.streamapi.service;

import com.drot.streamapi.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class DepartmentsService {

    private EmployeeService employeeList;

    public DepartmentsService(EmployeeService employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> personId(int departmentNumber) {
        return employeeList.getEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> allPerson() {
        return employeeList.getEmployee().stream()
                .sorted(Comparator.comparingInt(employee -> employee.getDepartment()))
                .collect(Collectors.toList());
    }

    public Employee personMinSalary(int departmentNumber) {
        return employeeList.getEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);
    }

    public Employee personMaxSalary(int departmentNumber) {
        return employeeList.getEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);
    }

    public Integer departmentAllSalary(int departmentNumber) {
        Integer sum = employeeList.getEmployee().stream()
                .filter(employee -> employee.getDepartment() == departmentNumber)
                .mapToInt(Employee::getSalary)
                .sum();
        return sum;
    }

    public Map<Integer,List<Employee>> groupDeportment(){
        return employeeList.getEmployee()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}


