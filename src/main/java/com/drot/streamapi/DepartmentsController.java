package com.drot.streamapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentsController {

    private final DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Employee> allPerson() {
        return service.allPerson();
    }

    @GetMapping("all")
    public List<Employee> personId(@RequestParam("departmentId") int departmentId) {
        return service.personId(departmentId);
    }

    @GetMapping("min-salary")
    public Employee personMinSalary(@RequestParam("departmentId") int departmentId) {
        return service.personMinSalary(departmentId);
    }

    @GetMapping("max-salary")
    public Employee personMaxSalary(@RequestParam("departmentId") int departmentId) {
        return service.personMaxSalary(departmentId);
    }
}
