package com.jiro.student_marksheet_management.entities.teacher;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

    @OneToOne
    @JoinColumn(name = "coordinator_id", referencedColumnName = "teacherId")
    private Teacher coordinator;  // A department has one coordinator (who is also a teacher)
}
