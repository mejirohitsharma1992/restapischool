package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.Remarks;

import java.util.List;

public interface RemarksService {
    List<Remarks> getAllRemarks();
    Remarks getRemarksById(Long id);
    Remarks createRemarks(Remarks remarks);
    Remarks updateRemarks(Long id, Remarks remarks);
    void deleteRemarks(Long id);
}
