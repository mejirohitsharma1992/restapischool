package com.jiro.student_marksheet_management.services.interfaces.student;

import com.jiro.student_marksheet_management.entities.student.Batch;
import java.util.List;

public interface BatchService {
    Batch createBatch(Batch batch);
    Batch getBatchById(Long id);
    List<Batch> getAllBatches();
    Batch updateBatch(Long id, Batch batchDetails);
    void deleteBatch(Long id);
}
