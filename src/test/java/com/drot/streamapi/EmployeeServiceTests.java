package com.drot.streamapi;

import com.drot.streamapi.exteption.SyntaxError;
import com.drot.streamapi.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class EmployeeServiceTests {

    EmployeeService employeeService = new EmployeeService();
    Employee employee = new Employee("Александр", "Пушкин", 12547, 2);
    public String add1 = employeeService.addEmployee("Александр", "Пушкин", 12547, 2);
    public String add2 = employeeService.addEmployee("Сергей", "Грашин", 13567, 1);


    @Test
    void searchTest() {
        var searchIndex1 = employeeService.searchEmployee("Александр", "Пушкин", 12547, 2);
        assertEquals(0, searchIndex1);
        var searchIndex2 = employeeService.searchEmployee("Сергей", "Грашин", 13567, 1);
        assertEquals(1, searchIndex2);
    }

    @Test
    void addTest() {
        var emp = employee.toString();
        assertEquals(emp,add1);
    }

    @Test
    void findTest() {
        var find1 = employeeService.findEmployee("Александр", "Пушкин", 12547, 2);
        assertEquals(add1,find1);
        var find2 = employeeService.findEmployee("Сергей", "Грашин", 13567, 1);
        assertEquals(add2,find2);
    }

    @Test
    void removeTest() {
        employeeService.removeEmployee("Александр", "Пушкин", 12547, 2);
        var find = employeeService.findEmployee("Александр", "Пушкин", 12547, 2);
        assertEquals("EmployeeNotFoundException",find);
    }

    @Test
    void syntaxTest() {
        assertThrows(SyntaxError.class, () -> employeeService.syntax("Александр", "Пу4кин"));
        assertThrows(SyntaxError.class, () -> employeeService.syntax("Ви_олла", "Тараканова"));
    }

    @Test
    void empSizeTest() {
        assertEquals(false,  employeeService.empSize());
        employeeService.removeEmployee("Александр", "Пушкин", 12547, 2);
        employeeService.removeEmployee("Сергей", "Грашин", 13567, 1);
        assertEquals(true,  employeeService.empSize());
    }
}
