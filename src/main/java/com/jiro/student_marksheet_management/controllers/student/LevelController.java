package com.jiro.student_marksheet_management.controllers.student;

import com.jiro.student_marksheet_management.entities.student.Level;
import com.jiro.student_marksheet_management.services.interfaces.student.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelService levelService;

    @Autowired
    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping
    public ResponseEntity<Level> createLevel(@RequestBody Level level) {
        return ResponseEntity.ok(levelService.createLevel(level));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.getLevelById(id));
    }

    @GetMapping
    public ResponseEntity<List<Level>> getAllLevels() {
        return ResponseEntity.ok(levelService.getAllLevels());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Level> updateLevel(@PathVariable Long id, @RequestBody Level levelDetails) {
        return ResponseEntity.ok(levelService.updateLevel(id, levelDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
        return ResponseEntity.noContent().build();
    }
}
