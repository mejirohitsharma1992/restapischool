package com.jiro.student_marksheet_management.services.impl.academic;

import com.jiro.student_marksheet_management.entities.academic.ResultPublished;
import com.jiro.student_marksheet_management.repositories.academic.ResultPublishedRepository;
import com.jiro.student_marksheet_management.services.interfaces.academic.ResultPublishedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultPublishedServiceImpl implements ResultPublishedService {

    @Autowired
    private ResultPublishedRepository resultPublishedRepository;

    @Override
    public List<ResultPublished> getAllResultsPublished() {
        return resultPublishedRepository.findAll();
    }

    @Override
    public ResultPublished getResultPublishedById(Long id) {
        Optional<ResultPublished> resultPublished = resultPublishedRepository.findById(id);
        return resultPublished.orElseThrow(() -> new RuntimeException("ResultPublished not found with id " + id));
    }

    @Override
    public ResultPublished createResultPublished(ResultPublished resultPublished) {
        return resultPublishedRepository.save(resultPublished);
    }

    @Override
    public ResultPublished updateResultPublished(Long id, ResultPublished resultPublished) {
        ResultPublished existingResultPublished = getResultPublishedById(id);
        existingResultPublished.setBatchName(resultPublished.getBatchName());
        existingResultPublished.setExamType(resultPublished.getExamType());
        existingResultPublished.setDate(resultPublished.getDate());
        existingResultPublished.setStatus(resultPublished.getStatus());
        return resultPublishedRepository.save(existingResultPublished);
    }

    @Override
    public void deleteResultPublished(Long id) {
        resultPublishedRepository.deleteById(id);
    }
}
