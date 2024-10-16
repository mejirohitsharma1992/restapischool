package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Level;
import java.util.List;

public interface LevelService {
    Level createLevel(Level level);
    Level getLevelById(Long id);
    List<Level> getAllLevels();
    Level updateLevel(Long id, Level levelDetails);
    void deleteLevel(Long id);
}
