package com.jiro.student_marksheet_management.services.impl.teacher;

import com.jiro.student_marksheet_management.entities.teacher.Department;
import com.jiro.student_marksheet_management.entities.teacher.Teacher;
import com.jiro.student_marksheet_management.repositories.teacher.DepartmentRepository;
import com.jiro.student_marksheet_management.repositories.teacher.TeacherRepository;
import com.jiro.student_marksheet_management.services.interfaces.teacher.DepartmentService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Department assignCoordinatorToDepartment(Long departmentId, Long teacherId) {
        Optional<Department> departmentEntities = departmentRepository.findById(departmentId);
        Optional<Teacher> teacherEntities = teacherRepository.findById(teacherId);

        return departmentEntities.flatMap(department ->
                teacherEntities.map(teacher -> {
                    department.setCoordinator(teacher);
                    return departmentRepository.save(department);
                })).orElse(null);
    }

    @Override
    public Department getAssignedDepartmentOfCoordinator(Long teacherId) {
        Teacher teacherEntities = Teacher.builder().teacherId(teacherId).build();
        return departmentRepository.findByCoordinator(teacherEntities);
    }

    @Override
    public Department createNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
