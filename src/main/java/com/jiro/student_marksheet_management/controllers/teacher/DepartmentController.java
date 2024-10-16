package com.jiro.student_marksheet_management.controllers.teacher;

import com.jiro.student_marksheet_management.entities.teacher.Department;
import com.jiro.student_marksheet_management.services.interfaces.teacher.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Create a new department
    @PostMapping
    public Department createNewDepartment(@RequestBody Department department) {
        return departmentService.createNewDepartment(department);
    }

    // Get department by ID
    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    // Assign a coordinator to the department
    @PutMapping(path = "/{departmentId}/manager/{teacherId}")
    public Department assignCoordinatorToDepartment(@PathVariable Long departmentId, @PathVariable Long teacherId) {
        return departmentService.assignCoordinatorToDepartment(departmentId, teacherId);
    }

    // Get assigned department of the coordinator (teacher)
    @GetMapping(path = "/assignedDepartmentOfCoordinator/{teacherId}")
    public Department getAssignedDepartmentOfCoordinator(@PathVariable Long teacherId) {
        return departmentService.getAssignedDepartmentOfCoordinator(teacherId);
    }

    // Delete a department by ID
    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
