package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.ExamType;
import com.jiro.student_marksheet_management.repositories.academic.ExamTypeRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @Override
    public List<ExamType> getAllExamTypes() {
        return examTypeRepository.findAll();
    }

    @Override
    public ExamType createExamType(ExamType examType) {
        return examTypeRepository.save(examType);
    }

    @Override
    public ExamType updateExamType(Long id, ExamType examType) {
        Optional<ExamType> existingExamType = examTypeRepository.findById(id);
        if (existingExamType.isPresent()) {
            ExamType updatedExamType = existingExamType.get();
            updatedExamType.setType(examType.getType());
            updatedExamType.setStatus(examType.getStatus());
            return examTypeRepository.save(updatedExamType);
        } else {
            throw new RuntimeException("ExamType not found with id " + id);
        }
    }

    @Override
    public void deleteExamType(Long id) {
        examTypeRepository.deleteById(id);
    }
}
