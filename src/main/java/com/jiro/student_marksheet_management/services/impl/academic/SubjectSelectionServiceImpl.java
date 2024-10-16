package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.SubjectSelection;
import com.jiro.student_marksheet_management.repositories.academic.SubjectSelectionRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.SubjectSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectSelectionServiceImpl implements SubjectSelectionService {

    @Autowired
    private SubjectSelectionRepository subjectSelectionRepository;

    @Override
    public List<SubjectSelection> getAllSubjectSelections() {
        return subjectSelectionRepository.findAll();
    }

    @Override
    public SubjectSelection getSubjectSelectionById(Long id) {
        Optional<SubjectSelection> subjectSelection = subjectSelectionRepository.findById(id);
        return subjectSelection.orElseThrow(() -> new RuntimeException("SubjectSelection not found with id " + id));
    }

    @Override
    public SubjectSelection createSubjectSelection(SubjectSelection subjectSelection) {
        return subjectSelectionRepository.save(subjectSelection);
    }

    @Override
    public SubjectSelection updateSubjectSelection(Long id, SubjectSelection subjectSelection) {
        SubjectSelection existingSubjectSelection = getSubjectSelectionById(id);
        existingSubjectSelection.setFaculty(subjectSelection.getFaculty());
        existingSubjectSelection.setLevel(subjectSelection.getLevel());
        existingSubjectSelection.setProgram(subjectSelection.getProgram());
        existingSubjectSelection.setSchoolClass(subjectSelection.getSchoolClass());
        existingSubjectSelection.setSection(subjectSelection.getSection());
        existingSubjectSelection.setExamType(subjectSelection.getExamType());
        existingSubjectSelection.setRollNo(subjectSelection.getRollNo());
        existingSubjectSelection.setStudentName(subjectSelection.getStudentName());
        existingSubjectSelection.setIsOptional(subjectSelection.getIsOptional());
        return subjectSelectionRepository.save(existingSubjectSelection);
    }

    @Override
    public void deleteSubjectSelection(Long id) {
        subjectSelectionRepository.deleteById(id);
    }
}
