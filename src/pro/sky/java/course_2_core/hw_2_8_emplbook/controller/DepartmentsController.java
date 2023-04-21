package pro.sky.java.course_2_core.hw_2_8_emplbook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course_2_core.employee.model.Employee;
import pro.sky.java.course_2_core.hw_2_8_emplbook.service.DepartmentsService;


import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    final private DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    /**
     * @return Employee with minimum wage within department.
     **/
    @GetMapping("/min-salary")
    Employee getMinPaidEmployee(int departmentId) {
        return service.findMinSalaryEmployeeInDepartment(departmentId);
    }

    /**
     * @return Employee with maximum wage within department.
     **/
    @GetMapping("/max-salary")
    Employee getMaxPaidEmployee(int departmentId) {
        return service.findMaxSalaryEmployeeInDepartment(departmentId);
    }


    @GetMapping("/all")
    Collection<Employee> dispatchGetAllEmployees(@RequestParam(required = false) Integer departmentId) {
        System.out.println("hello");
        if(departmentId == null) {
            return service.getAllEmployeesByDepartments();
        }
        return service.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all-by-departments")
    Collection<Employee> getAllEmployeesByDepartments() {
        return service.getAllEmployeesByDepartments();
    }



}
