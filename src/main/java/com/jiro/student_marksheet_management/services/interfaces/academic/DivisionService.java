package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.Division;

import java.util.List;

public interface DivisionService {
    List<Division> getAllDivisions();
    Division getDivisionById(Long id);
    Division createDivision(Division division);
    Division updateDivision(Long id, Division division);
    void deleteDivision(Long id);
}
