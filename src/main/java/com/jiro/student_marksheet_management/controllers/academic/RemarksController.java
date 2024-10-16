package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.Remarks;
import com.jiro.student_marksheet_management.services.interfaces.academic.RemarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remarks")
public class RemarksController {

    @Autowired
    private RemarksService remarksService;

    @GetMapping
    public List<Remarks> getAllRemarks() {
        return remarksService.getAllRemarks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Remarks> getRemarksById(@PathVariable Long id) {
        Remarks remarks = remarksService.getRemarksById(id);
        return ResponseEntity.ok(remarks);
    }

    @PostMapping
    public ResponseEntity<Remarks> createRemarks(@RequestBody Remarks remarks) {
        Remarks createdRemarks = remarksService.createRemarks(remarks);
        return ResponseEntity.ok(createdRemarks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Remarks> updateRemarks(@PathVariable Long id, @RequestBody Remarks remarks) {
        Remarks updatedRemarks = remarksService.updateRemarks(id, remarks);
        return ResponseEntity.ok(updatedRemarks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemarks(@PathVariable Long id) {
        remarksService.deleteRemarks(id);
        return ResponseEntity.noContent().build();
    }
}
