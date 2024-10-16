package com.jiro.student_marksheet_management.entities.student;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sectionName;

    @ManyToOne
    private SchoolClass schoolClass;



}

