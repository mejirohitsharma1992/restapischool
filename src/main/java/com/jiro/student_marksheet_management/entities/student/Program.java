package com.jiro.student_marksheet_management.entities.student;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String programName;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Level level;
    // Getters, setters, constructors
}

