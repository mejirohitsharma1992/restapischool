package com.jiro.student_marksheet_management.entities.academic;
import com.jiro.student_marksheet_management.entities.student.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarksEntry {
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
    private Section section;

    @ManyToOne
    private ExamType examType;

    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String rollNo;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private Integer theoryMarks;
    @Column(nullable = false)
    private Integer practicalMarks;
}

