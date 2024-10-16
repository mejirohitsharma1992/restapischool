package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Faculty;
import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);
    Faculty getFacultyById(Long id);
    List<Faculty> getAllFaculties();
    Faculty updateFaculty(Long id, Faculty facultyDetails);
    void deleteFaculty(Long id);
}
