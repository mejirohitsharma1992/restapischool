package com.jiro.student_marksheet_management.repositories.teacher;

import com.jiro.student_marksheet_management.entities.teacher.Department;
import com.jiro.student_marksheet_management.entities.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByCoordinator(Teacher teacher);
}
