package com.jiro.student_marksheet_management.repositories.student;

import com.jiro.student_marksheet_management.entities.student.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
}
