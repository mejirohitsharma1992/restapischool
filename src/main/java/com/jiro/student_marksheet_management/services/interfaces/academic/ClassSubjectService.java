package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.ClassSubject;

import java.util.List;

public interface ClassSubjectService {
    List<ClassSubject> getAllClassSubjects();
    ClassSubject getClassSubjectById(Long id);
    ClassSubject createClassSubject(ClassSubject classSubject);
    ClassSubject updateClassSubject(Long id, ClassSubject classSubject);
    void deleteClassSubject(Long id);
}
