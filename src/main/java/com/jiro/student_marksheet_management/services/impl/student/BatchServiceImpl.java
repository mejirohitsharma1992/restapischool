package com.jiro.student_marksheet_management.services.impl.student;

import com.jiro.student_marksheet_management.entities.student.Batch;
import com.jiro.student_marksheet_management.repositories.student.BatchRepository;
import com.jiro.student_marksheet_management.services.interfaces.student.BatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    @Override
    public Batch getBatchById(Long id) {
        return batchRepository.findById(id).orElseThrow(() -> new RuntimeException("Batch not found"));
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Batch updateBatch(Long id, Batch batchDetails) {
        Batch batch = batchRepository.findById(id).orElseThrow(() -> new RuntimeException("Batch not found"));
        batch.setBatchName(batchDetails.getBatchName());
        return batchRepository.save(batch);
    }

    @Override
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}
