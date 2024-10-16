package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Section;

import java.util.List;

public interface SectionService {
    Section createSection(Section section);

    Section getSectionById(Long id);

    List<Section> getAllSections();

    Section updateSection(Long id, Section sectionDetails);

    void deleteSection(Long id);
}
