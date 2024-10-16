package com.jiro.student_marksheet_management.repositories.academic;

import com.jiro.student_marksheet_management.entities.academic.SubjectSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectSelectionRepository extends JpaRepository<SubjectSelection, Long> {
}
