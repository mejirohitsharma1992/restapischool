package com.jiro.student_marksheet_management.repositories.academic;

import com.jiro.student_marksheet_management.entities.academic.MarksEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksEntryRepository extends JpaRepository<MarksEntry, Long> {
}
