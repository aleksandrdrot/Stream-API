package com.drot.streamapi;

import com.drot.streamapi.service.DepartmentsService;
import com.drot.streamapi.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class DepartmentsServiceTest {
    @Mock
    EmployeeService employeeMock;

    DepartmentsService out;

    static List<Employee> employeeList =
            List.of(
                    new Employee( "Александр","Пушкин", 1254, 2),
                    new Employee("Александр","Гришин", 1452, 2),
                    new Employee( "Максим","Пупков", 1236, 1),
                    new Employee("Александр","Пупков", 1456, 1),
                    new Employee("Дмитрий","Перов", 1258,3)
            );

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        out = new DepartmentsService(employeeMock);
    }

    @Test
    void personMaxSalary(){
        when(employeeMock.getEmployee()).thenReturn(employeeList);
        assertNull(out.personMaxSalary(4));
        assertEquals(new Employee( "Александр","Гришин", 1452, 2),out.personMaxSalary(2));
    }

    @Test
    void personMinSalary(){
        when(employeeMock.getEmployee()).thenReturn(employeeList);
        assertNull(out.personMinSalary(4));
        assertEquals(employeeList.get(2),out.personMinSalary(1));
    }

    @Test
    void personId(){
        when(employeeMock.getEmployee()).thenReturn(employeeList);
        assertNull(out.personMinSalary(4));
        var departmentPerson = out.personId(2);
        assertEquals(2,departmentPerson.size());
    }

    @Test
    void departmentAllSalary(){
        when(employeeMock.getEmployee()).thenReturn(employeeList);
        int sum1 = out.departmentAllSalary(2);
        assertEquals(2706, sum1);
        int sum2 = out.departmentAllSalary(1);
        assertEquals(2692, sum2);
        int sum3 = out.departmentAllSalary(4);
        assertEquals(0, sum3);
    }

    @Test
    void groupDeportment(){
        when(employeeMock.getEmployee()).thenReturn(employeeList);
        assertNotNull(out.groupDeportment());
        var group = out.groupDeportment();
        assertEquals(3, group.size());
    }


}
