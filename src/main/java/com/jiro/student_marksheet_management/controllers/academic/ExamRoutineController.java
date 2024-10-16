package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamRoutine;
import com.jiro.student_marksheet_management.services.interfaces.academic.ExamRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-routine")
public class ExamRoutineController {

    @Autowired
    private ExamRoutineService examRoutineService;

    @GetMapping
    public List<ExamRoutine> getAllExamRoutines() {
        return examRoutineService.getAllExamRoutines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamRoutine> getExamRoutineById(@PathVariable Long id) {
        ExamRoutine examRoutine = examRoutineService.getExamRoutineById(id);
        return ResponseEntity.ok(examRoutine);
    }

    @PostMapping
    public ResponseEntity<ExamRoutine> createExamRoutine(@RequestBody ExamRoutine examRoutine) {
        ExamRoutine createdExamRoutine = examRoutineService.createExamRoutine(examRoutine);
        return ResponseEntity.ok(createdExamRoutine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamRoutine> updateExamRoutine(@PathVariable Long id, @RequestBody ExamRoutine examRoutine) {
        ExamRoutine updatedExamRoutine = examRoutineService.updateExamRoutine(id, examRoutine);
        return ResponseEntity.ok(updatedExamRoutine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamRoutine(@PathVariable Long id) {
        examRoutineService.deleteExamRoutine(id);
        return ResponseEntity.noContent().build();
    }
}
