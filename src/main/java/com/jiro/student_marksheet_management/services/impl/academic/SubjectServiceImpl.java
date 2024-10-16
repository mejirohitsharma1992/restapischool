package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.Subject;
import com.jiro.student_marksheet_management.repositories.academic.SubjectRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElseThrow(() -> new RuntimeException("Subject not found with id " + id));
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Long id, Subject subject) {
        Subject existingSubject = getSubjectById(id);
        existingSubject.setCode(subject.getCode());
        existingSubject.setSubjectName(subject.getSubjectName());
        existingSubject.setTheoryFM(subject.getTheoryFM());
        existingSubject.setTheoryPM(subject.getTheoryPM());
        existingSubject.setPracticalFM(subject.getPracticalFM());
        existingSubject.setPracticalPM(subject.getPracticalPM());
        existingSubject.setCategory(subject.getCategory());
        existingSubject.setStatus(subject.getStatus());
        return subjectRepository.save(existingSubject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
