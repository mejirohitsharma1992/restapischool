package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.Division;
import com.jiro.student_marksheet_management.repositories.academic.DivisionRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    @Override
    public Division getDivisionById(Long id) {
        Optional<Division> division = divisionRepository.findById(id);
        return division.orElseThrow(() -> new RuntimeException("Division not found with id " + id));
    }

    @Override
    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public Division updateDivision(Long id, Division division) {
        Division existingDivision = getDivisionById(id);
        existingDivision.setDivisionName(division.getDivisionName());
        existingDivision.setPercentageBelow(division.getPercentageBelow());
        return divisionRepository.save(existingDivision);
    }

    @Override
    public void deleteDivision(Long id) {
        divisionRepository.deleteById(id);
    }
}
