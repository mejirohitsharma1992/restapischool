package com.jiro.student_marksheet_management.entities.academic;
import com.jiro.student_marksheet_management.entities.student.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamRoutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Level level;

    @ManyToOne
    private Program program;

    @ManyToOne
    private SchoolClass schoolClass;

    @ManyToOne
    private ExamType examType;

    @Column(nullable = false)
    private String subjectName;
    @Column(nullable = false)
    private LocalDate examDate;
    @Column(nullable = false)
    private String examTime;
}
