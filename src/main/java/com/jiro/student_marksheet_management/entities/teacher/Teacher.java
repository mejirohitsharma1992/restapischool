package com.jiro.student_marksheet_management.entities.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "departmentId")
    private Department department;  // A teacher belongs to one department

    private String subjectTaught;  // The subject the teacher teaches
    private String status;  // Active, Inactive, etc.

    @OneToOne(mappedBy = "coordinator")
    @JsonIgnore
    private Department managedDepartment;  // The department this teacher manages (as coordinator)
}
