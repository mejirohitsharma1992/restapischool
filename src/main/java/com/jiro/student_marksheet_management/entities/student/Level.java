package com.jiro.student_marksheet_management.entities.student;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String levelName;

    @ManyToOne
    private Faculty faculty;
    // Getters, setters, constructors
}

