package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.SchoolClass;
import java.util.List;

public interface ClassService {
    SchoolClass createClass(SchoolClass classEntity);
    SchoolClass getClassById(Long id);
    List<SchoolClass> getAllClasses();
    SchoolClass updateClass(Long id, SchoolClass classDetails);
    void deleteClass(Long id);
}
