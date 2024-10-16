package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.SubjectSelection;
import com.jiro.student_marksheet_management.services.interfaces.academic.SubjectSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject-selections")
public class SubjectSelectionController {

    @Autowired
    private SubjectSelectionService subjectSelectionService;

    @GetMapping
    public List<SubjectSelection> getAllSubjectSelections() {
        return subjectSelectionService.getAllSubjectSelections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectSelection> getSubjectSelectionById(@PathVariable Long id) {
        SubjectSelection subjectSelection = subjectSelectionService.getSubjectSelectionById(id);
        return ResponseEntity.ok(subjectSelection);
    }

    @PostMapping
    public ResponseEntity<SubjectSelection> createSubjectSelection(@RequestBody SubjectSelection subjectSelection) {
        SubjectSelection createdSubjectSelection = subjectSelectionService.createSubjectSelection(subjectSelection);
        return ResponseEntity.ok(createdSubjectSelection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectSelection> updateSubjectSelection(@PathVariable Long id, @RequestBody SubjectSelection subjectSelection) {
        SubjectSelection updatedSubjectSelection = subjectSelectionService.updateSubjectSelection(id, subjectSelection);
        return ResponseEntity.ok(updatedSubjectSelection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectSelection(@PathVariable Long id) {
        subjectSelectionService.deleteSubjectSelection(id);
        return ResponseEntity.noContent().build();
    }
}
