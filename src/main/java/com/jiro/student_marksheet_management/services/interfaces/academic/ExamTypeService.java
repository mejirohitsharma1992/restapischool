package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamType;

import java.util.List;

public interface ExamTypeService {
    List<ExamType> getAllExamTypes();
    ExamType createExamType(ExamType examType);
    ExamType updateExamType(Long id, ExamType examType);
    void deleteExamType(Long id);
}
