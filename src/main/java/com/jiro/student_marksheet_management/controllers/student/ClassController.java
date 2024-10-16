package com.jiro.student_marksheet_management.controllers.student;

import com.jiro.student_marksheet_management.entities.student.SchoolClass;
import com.jiro.student_marksheet_management.services.interfaces.student.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<SchoolClass> createClass(@RequestBody SchoolClass classEntity) {
        return ResponseEntity.ok(classService.createClass(classEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClass> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolClass> updateClass(@PathVariable Long id, @RequestBody SchoolClass classDetails) {
        return ResponseEntity.ok(classService.updateClass(id, classDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}

