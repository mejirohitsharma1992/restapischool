package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamRoutine;
import com.jiro.student_marksheet_management.repositories.academic.ExamRoutineRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.ExamRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamRoutineServiceImpl implements ExamRoutineService {

    @Autowired
    private ExamRoutineRepository examRoutineRepository;

    @Override
    public List<ExamRoutine> getAllExamRoutines() {
        return examRoutineRepository.findAll();
    }

    @Override
    public ExamRoutine getExamRoutineById(Long id) {
        Optional<ExamRoutine> examRoutine = examRoutineRepository.findById(id);
        return examRoutine.orElseThrow(() -> new RuntimeException("ExamRoutine not found with id " + id));
    }

    @Override
    public ExamRoutine createExamRoutine(ExamRoutine examRoutine) {
        return examRoutineRepository.save(examRoutine);
    }

    @Override
    public ExamRoutine updateExamRoutine(Long id, ExamRoutine examRoutine) {
        ExamRoutine existingExamRoutine = getExamRoutineById(id);
        existingExamRoutine.setFaculty(examRoutine.getFaculty());
        existingExamRoutine.setLevel(examRoutine.getLevel());
        existingExamRoutine.setProgram(examRoutine.getProgram());
        existingExamRoutine.setSchoolClass(examRoutine.getSchoolClass());
        existingExamRoutine.setExamType(examRoutine.getExamType());
        existingExamRoutine.setSubjectName(examRoutine.getSubjectName());
        existingExamRoutine.setExamDate(examRoutine.getExamDate());
        existingExamRoutine.setExamTime(examRoutine.getExamTime());
        return examRoutineRepository.save(existingExamRoutine);
    }

    @Override
    public void deleteExamRoutine(Long id) {
        examRoutineRepository.deleteById(id);
    }
}
