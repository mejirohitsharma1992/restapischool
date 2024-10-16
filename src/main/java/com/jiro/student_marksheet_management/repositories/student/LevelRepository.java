package com.jiro.student_marksheet_management.repositories.student;
    import com.jiro.student_marksheet_management.entities.student.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}