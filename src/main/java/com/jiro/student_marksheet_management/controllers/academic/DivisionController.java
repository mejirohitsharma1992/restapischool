package com.jiro.student_marksheet_management.controllers.academic;

import com.jiro.student_marksheet_management.entities.academic.Division;
import com.jiro.student_marksheet_management.services.interfaces.academic.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping
    public List<Division> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable Long id) {
        Division division = divisionService.getDivisionById(id);
        return ResponseEntity.ok(division);
    }

    @PostMapping
    public ResponseEntity<Division> createDivision(@RequestBody Division division) {
        Division createdDivision = divisionService.createDivision(division);
        return ResponseEntity.ok(createdDivision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable Long id, @RequestBody Division division) {
        Division updatedDivision = divisionService.updateDivision(id, division);
        return ResponseEntity.ok(updatedDivision);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable Long id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }
}
