package com.jiro.student_marksheet_management.services.impl.student;
import com.jiro.student_marksheet_management.entities.student.Level;
import com.jiro.student_marksheet_management.repositories.student.LevelRepository;
import com.jiro.student_marksheet_management.services.interfaces.student.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElseThrow(() -> new RuntimeException("Level not found"));
    }

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public Level updateLevel(Long id, Level levelDetails) {
        Level level = levelRepository.findById(id).orElseThrow(() -> new RuntimeException("Level not found"));
        level.setLevelName(levelDetails.getLevelName());
        // Other setters
        return levelRepository.save(level);
    }

    @Override
    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }
}
