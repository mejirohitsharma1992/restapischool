package com.jiro.student_marksheet_management.controllers.Audit;

import com.jiro.student_marksheet_management.entities.academic.ResultPublished;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/resultPublished/{resultId}")
    List<ResultPublished> getResultPublishedEntity(@PathVariable Long resultId){
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions=reader.getRevisions(ResultPublished.class,resultId);
        return revisions.stream().map(revisionNumber->reader.find(ResultPublished.class,resultId,revisionNumber))
                .collect(Collectors.toList());
    }
}
