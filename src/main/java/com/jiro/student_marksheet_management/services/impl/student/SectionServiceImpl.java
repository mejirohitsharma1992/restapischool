package com.jiro.student_marksheet_management.services.impl.student;
import com.jiro.student_marksheet_management.entities.student.Section;
import com.jiro.student_marksheet_management.repositories.student.SectionRepository;
import com.jiro.student_marksheet_management.services.interfaces.student.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section getSectionById(Long id) {
        return sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section updateSection(Long id, Section sectionDetails) {
        Section section = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
        section.setSectionName(sectionDetails.getSectionName());
        // Other setters
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
