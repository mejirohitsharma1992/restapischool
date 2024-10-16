package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.MarksEntry;

import java.util.List;

public interface MarksEntryService {
    List<MarksEntry> getAllMarksEntries();
    MarksEntry getMarksEntryById(Long id);
    MarksEntry createMarksEntry(MarksEntry marksEntry);
    MarksEntry updateMarksEntry(Long id, MarksEntry marksEntry);
    void deleteMarksEntry(Long id);
}
