package com.jikjii.Springboot.v1.controller;

import com.jikjii.Springboot.v1.entity.Department;
import com.jikjii.Springboot.v1.error.DepartmentNotFoundException;
import com.jikjii.Springboot.v1.service.DepartmentService;
import com.jikjii.Springboot.v1.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Logger implemented
    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    // Save department method - saves one department to db
    // @Valid allows for validation from the request against the
    // @NotBlank in the entity package
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController ");
        return departmentService.saveDepartment(department);
    }

    // Find departments method - finds all departments in db
    // EXAMPLE - of using logger below inside of GET method
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartment of DepartmentController ");
        return departmentService.fetchDepartmentList();
    }

    // Find department method = finds a single department by id
    // the path is dynamic - gives the ability to find department when entering an id
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
