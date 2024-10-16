package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.ClassSubject;
import com.jiro.student_marksheet_management.services.interfaces.academic.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-subject")
public class ClassSubjectController {

    @Autowired
    private ClassSubjectService classSubjectService;

    @GetMapping
    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectService.getAllClassSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSubject> getClassSubjectById(@PathVariable Long id) {
        ClassSubject classSubject = classSubjectService.getClassSubjectById(id);
        return ResponseEntity.ok(classSubject);
    }

    @PostMapping
    public ResponseEntity<ClassSubject> createClassSubject(@RequestBody ClassSubject classSubject) {
        ClassSubject createdClassSubject = classSubjectService.createClassSubject(classSubject);
        return ResponseEntity.ok(createdClassSubject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSubject> updateClassSubject(@PathVariable Long id, @RequestBody ClassSubject classSubject) {
        ClassSubject updatedClassSubject = classSubjectService.updateClassSubject(id, classSubject);
        return ResponseEntity.ok(updatedClassSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassSubject(@PathVariable Long id) {
        classSubjectService.deleteClassSubject(id);
        return ResponseEntity.noContent().build();
    }
}
