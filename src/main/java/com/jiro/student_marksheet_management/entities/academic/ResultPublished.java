package com.jiro.student_marksheet_management.entities.academic;
import com.jiro.student_marksheet_management.entities.student.Batch;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultPublished {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Batch batchName;

    @ManyToOne
    private ExamType examType;

    @Column(nullable = false)
    private LocalDate date;
    private Boolean status;  // Published status
}

