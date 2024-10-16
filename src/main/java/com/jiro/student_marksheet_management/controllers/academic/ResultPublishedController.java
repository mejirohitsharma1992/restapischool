package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.ResultPublished;
import com.jiro.student_marksheet_management.services.interfaces.academic.ResultPublishedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result-published")
public class ResultPublishedController {

    @Autowired
    private ResultPublishedService resultPublishedService;

    @GetMapping
    public List<ResultPublished> getAllResultsPublished() {
        return resultPublishedService.getAllResultsPublished();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultPublished> getResultPublishedById(@PathVariable Long id) {
        ResultPublished resultPublished = resultPublishedService.getResultPublishedById(id);
        return ResponseEntity.ok(resultPublished);
    }

    @PostMapping
    public ResponseEntity<ResultPublished> createResultPublished(@RequestBody ResultPublished resultPublished) {
        ResultPublished createdResultPublished = resultPublishedService.createResultPublished(resultPublished);
        return ResponseEntity.ok(createdResultPublished);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultPublished> updateResultPublished(@PathVariable Long id, @RequestBody ResultPublished resultPublished) {
        ResultPublished updatedResultPublished = resultPublishedService.updateResultPublished(id, resultPublished);
        return ResponseEntity.ok(updatedResultPublished);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultPublished(@PathVariable Long id) {
        resultPublishedService.deleteResultPublished(id);
        return ResponseEntity.noContent().build();
    }
}
