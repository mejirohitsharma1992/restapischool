package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Student;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);
}
