package com.jiro.student_marksheet_management.entities.student;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String className;

    @ManyToOne
    private Program program;
    // Getters, setters, constructors
}

