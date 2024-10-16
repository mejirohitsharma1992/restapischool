package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.MarksEntry;
import com.jiro.student_marksheet_management.services.interfaces.academic.MarksEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks-entry")
public class MarksEntryController {

    @Autowired
    private MarksEntryService marksEntryService;

    @GetMapping
    public List<MarksEntry> getAllMarksEntries() {
        return marksEntryService.getAllMarksEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarksEntry> getMarksEntryById(@PathVariable Long id) {
        MarksEntry marksEntry = marksEntryService.getMarksEntryById(id);
        return ResponseEntity.ok(marksEntry);
    }

    @PostMapping
    public ResponseEntity<MarksEntry> createMarksEntry(@RequestBody MarksEntry marksEntry) {
        MarksEntry createdMarksEntry = marksEntryService.createMarksEntry(marksEntry);
        return ResponseEntity.ok(createdMarksEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarksEntry> updateMarksEntry(@PathVariable Long id, @RequestBody MarksEntry marksEntry) {
        MarksEntry updatedMarksEntry = marksEntryService.updateMarksEntry(id, marksEntry);
        return ResponseEntity.ok(updatedMarksEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarksEntry(@PathVariable Long id) {
        marksEntryService.deleteMarksEntry(id);
        return ResponseEntity.noContent().build();
    }
}
