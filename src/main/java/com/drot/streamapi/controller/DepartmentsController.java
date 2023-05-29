package com.drot.streamapi.controller;

import com.drot.streamapi.service.DepartmentsService;
import com.drot.streamapi.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentsController {

    private final DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Employee> allPerson() {
        return service.allPerson();
    }

    @GetMapping("employees")
    public Map<Integer,List<Employee>> groupDeportment() {
        return groupDeportment();
    }

    @GetMapping("{id}/employees")
    public List<Employee> personId(@PathVariable int id) {
        return service.personId(id);
    }

    @GetMapping("{id}/salary/min")
    public Employee personMinSalary(@PathVariable int id) {
        return service.personMinSalary(id);
    }

    @GetMapping("{id}/salary/max")
    public Employee personMaxSalary(@PathVariable int id) {
        return service.personMaxSalary(id);
    }

    @GetMapping("{id}/salary/sum")
    public String departmentAllSalary(@PathVariable int id){
        return service.departmentAllSalary(id).toString();
    }
}
