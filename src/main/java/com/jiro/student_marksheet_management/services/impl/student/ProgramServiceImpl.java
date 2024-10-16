package com.jiro.student_marksheet_management.services.impl.student;

import com.jiro.student_marksheet_management.entities.student.Program;
import com.jiro.student_marksheet_management.repositories.student.ProgramRepository;
import com.jiro.student_marksheet_management.services.interfaces.student.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    @Override
    public Program getProgramById(Long id) {
        return programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program updateProgram(Long id, Program programDetails) {
        Program program = programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
        program.setProgramName(programDetails.getProgramName());
        // Other setters
        return programRepository.save(program);
    }

    @Override
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
