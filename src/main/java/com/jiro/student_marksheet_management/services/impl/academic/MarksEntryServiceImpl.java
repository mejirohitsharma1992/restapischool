package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.MarksEntry;
import com.jiro.student_marksheet_management.repositories.academic.MarksEntryRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.MarksEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksEntryServiceImpl implements MarksEntryService {

    @Autowired
    private MarksEntryRepository marksEntryRepository;

    @Override
    public List<MarksEntry> getAllMarksEntries() {
        return marksEntryRepository.findAll();
    }

    @Override
    public MarksEntry getMarksEntryById(Long id) {
        Optional<MarksEntry> marksEntry = marksEntryRepository.findById(id);
        return marksEntry.orElseThrow(() -> new RuntimeException("MarksEntry not found with id " + id));
    }

    @Override
    public MarksEntry createMarksEntry(MarksEntry marksEntry) {
        return marksEntryRepository.save(marksEntry);
    }

    @Override
    public MarksEntry updateMarksEntry(Long id, MarksEntry marksEntry) {
        MarksEntry existingMarksEntry = getMarksEntryById(id);
        existingMarksEntry.setFaculty(marksEntry.getFaculty());
        existingMarksEntry.setLevel(marksEntry.getLevel());
        existingMarksEntry.setProgram(marksEntry.getProgram());
        existingMarksEntry.setSchoolClass(marksEntry.getSchoolClass());
        existingMarksEntry.setSection(marksEntry.getSection());
        existingMarksEntry.setExamType(marksEntry.getExamType());
        existingMarksEntry.setSubject(marksEntry.getSubject());
        existingMarksEntry.setRollNo(marksEntry.getRollNo());
        existingMarksEntry.setStudentName(marksEntry.getStudentName());
        existingMarksEntry.setTheoryMarks(marksEntry.getTheoryMarks());
        existingMarksEntry.setPracticalMarks(marksEntry.getPracticalMarks());
        return marksEntryRepository.save(existingMarksEntry);
    }

    @Override
    public void deleteMarksEntry(Long id) {
        marksEntryRepository.deleteById(id);
    }
}
