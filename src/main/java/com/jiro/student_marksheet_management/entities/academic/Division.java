package com.jiro.student_marksheet_management.entities.academic;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String divisionName;
    @Column(nullable = false)
    private Double percentageBelow;
}

