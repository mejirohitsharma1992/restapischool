package com.jiro.student_marksheet_management.entities.academic;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String subjectName;
    @Column(nullable = false)
    private Integer theoryFM;
    @Column(nullable = false)
    private Integer theoryPM;
    @Column(nullable = false)
    private Integer practicalFM;
    @Column(nullable = false)
    private Integer practicalPM;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private Boolean status;  // Published status
}

