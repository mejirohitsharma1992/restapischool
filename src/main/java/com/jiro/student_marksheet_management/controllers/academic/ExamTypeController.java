package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamType;
import com.jiro.student_marksheet_management.services.interfaces.academic.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examtypes")
public class ExamTypeController {

    @Autowired
    private ExamTypeService examTypeService;

    @GetMapping
    public List<ExamType> getAllExamTypes() {
        return examTypeService.getAllExamTypes();
    }

    @PostMapping
    public ExamType createExamType(@RequestBody ExamType examType) {
        return examTypeService.createExamType(examType);
    }

    @PutMapping("/{id}")
    public ExamType updateExamType(@PathVariable Long id, @RequestBody ExamType examType) {
        return examTypeService.updateExamType(id, examType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamType(@PathVariable Long id) {
        examTypeService.deleteExamType(id);
        return ResponseEntity.noContent().build();
    }
}
