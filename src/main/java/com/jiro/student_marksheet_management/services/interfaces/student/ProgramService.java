package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Program;
import java.util.List;

public interface ProgramService {
    Program createProgram(Program program);
    Program getProgramById(Long id);
    List<Program> getAllPrograms();
    Program updateProgram(Long id, Program programDetails);
    void deleteProgram(Long id);
}
