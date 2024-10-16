package com.jiro.student_marksheet_management.services.interfaces.teacher;

import com.jiro.student_marksheet_management.entities.teacher.Department;

public interface DepartmentService {
    Department assignCoordinatorToDepartment(Long departmentId, Long teacherId);
    Department getAssignedDepartmentOfCoordinator(Long teacherId);
    Department createNewDepartment(Department department);
    Department getDepartmentById(Long departmentId);
    void deleteDepartment(Long departmentId);
}
