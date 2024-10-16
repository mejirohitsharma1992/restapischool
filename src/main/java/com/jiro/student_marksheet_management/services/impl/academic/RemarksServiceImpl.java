package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.Remarks;
import com.jiro.student_marksheet_management.repositories.academic.RemarksRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.RemarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemarksServiceImpl implements RemarksService {

    @Autowired
    private RemarksRepository remarksRepository;

    @Override
    public List<Remarks> getAllRemarks() {
        return remarksRepository.findAll();
    }

    @Override
    public Remarks getRemarksById(Long id) {
        Optional<Remarks> remarks = remarksRepository.findById(id);
        return remarks.orElseThrow(() -> new RuntimeException("Remarks not found with id " + id));
    }

    @Override
    public Remarks createRemarks(Remarks remarks) {
        return remarksRepository.save(remarks);
    }

    @Override
    public Remarks updateRemarks(Long id, Remarks remarks) {
        Remarks existingRemarks = getRemarksById(id);
        existingRemarks.setRemarksTitle(remarks.getRemarksTitle());
        return remarksRepository.save(existingRemarks);
    }

    @Override
    public void deleteRemarks(Long id) {
        remarksRepository.deleteById(id);
    }
}
