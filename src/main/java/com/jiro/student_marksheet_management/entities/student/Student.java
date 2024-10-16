package com.jiro.student_marksheet_management.entities.student;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String religion;
    @Column(nullable = false)
    private String caste;
    private String bloodGroup;
    private String image;
    private String phoneNo;
    @Column(nullable = false)
    private String studentType;

    private String fatherName;
    private String fatherPhone;
    private String fatherEmail;
    private String motherName;
    private String motherPhone;
    private String motherEmail;
    private String guardianName;
    private String guardianPhone;
    private String guardianEmail;
    private String guardianType;

    @ManyToOne
    private Batch batch;
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
    // Getters, setters, constructors
}
