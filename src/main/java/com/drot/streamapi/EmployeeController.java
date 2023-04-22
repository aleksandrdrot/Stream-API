package com.drot.streamapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService listService;

    public EmployeeController(EmployeeService listService) {
        this.listService = listService;
    }


    @GetMapping("add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return listService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") int salary, @RequestParam("department") int department) {
        return listService.removeEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("find")
    public String findEmployee(String firstName, String lastName, int salary, int department) {
        return listService.findEmployee(firstName, lastName, salary, department);
    }
}
