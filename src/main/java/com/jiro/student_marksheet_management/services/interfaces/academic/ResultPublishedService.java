package com.jiro.student_marksheet_management.services.interfaces.academic;

import com.jiro.student_marksheet_management.entities.academic.ResultPublished;

import java.util.List;

public interface ResultPublishedService {
    List<ResultPublished> getAllResultsPublished();
    ResultPublished getResultPublishedById(Long id);
    ResultPublished createResultPublished(ResultPublished resultPublished);
    ResultPublished updateResultPublished(Long id, ResultPublished resultPublished);
    void deleteResultPublished(Long id);
}
