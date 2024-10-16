package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.SubjectSelection;

import java.util.List;

public interface SubjectSelectionService {
    List<SubjectSelection> getAllSubjectSelections();
    SubjectSelection getSubjectSelectionById(Long id);
    SubjectSelection createSubjectSelection(SubjectSelection subjectSelection);
    SubjectSelection updateSubjectSelection(Long id, SubjectSelection subjectSelection);
    void deleteSubjectSelection(Long id);
}
