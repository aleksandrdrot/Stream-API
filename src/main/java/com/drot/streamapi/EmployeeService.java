package com.drot.streamapi;

import com.drot.streamapi.exteption.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employee = new ArrayList<>();

    public int searchEmployee(String firstName, String lastName, int salary, int department) {
        int index = 0;
        for (; index < employee.size(); ) {
            if (employee.get(index).getFirstName().equals(firstName)) {
                if (employee.get(index).getLastName().equals(lastName)) {
                    break;
                }
            }
            index++;
            if (index == employee.size()) {
                throw new EmployeeNotFoundException();
            }
        }
        return index;
    }

        public String addEmployee (String firstName, String lastName,int salary, int department){
            Employee newEmployee = new Employee(firstName, lastName, salary, department);
            if (empSize()) {
                employee.add(newEmployee);
                return employee.get(0) + " Добавлен";
            } else {
                int index;
                try {
                    index = searchEmployee(firstName, lastName, salary, department);
                } catch (EmployeeNotFoundException e) {
                    employee.add(newEmployee);
                    return employee.get(employee.size() - 1) + " Добавлен";
                }
                return employee.get(index) + " EmployeeAlreadyAddedException";
            }
        }

        public String removeEmployee (String firstName, String lastName,int salary, int department){
            int index;
            try {
                index = searchEmployee(firstName, lastName, salary, department);
            } catch (EmployeeNotFoundException e) {
                return "EmployeeNotFoundException";
            }
            return employee.remove(index) + " Удалён";
        }

        public String findEmployee (String firstName, String lastName,int salary, int department){
            int index;
            try {
                index = searchEmployee(firstName, lastName, salary, department);
            } catch (EmployeeNotFoundException e) {
                return "EmployeeNotFoundException";
            }
            return employee.get(index).toString();
        }

        public boolean empSize () {
            if (employee.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
