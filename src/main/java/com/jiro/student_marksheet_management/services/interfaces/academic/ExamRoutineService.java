package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamRoutine;

import java.util.List;

public interface ExamRoutineService {
    List<ExamRoutine> getAllExamRoutines();
    ExamRoutine getExamRoutineById(Long id);
    ExamRoutine createExamRoutine(ExamRoutine examRoutine);
    ExamRoutine updateExamRoutine(Long id, ExamRoutine examRoutine);
    void deleteExamRoutine(Long id);
}
