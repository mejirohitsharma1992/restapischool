package com.jiro.student_marksheet_management.entities.academic;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jiro.student_marksheet_management.entities.Auditable.AuditableEntity;
import com.jiro.student_marksheet_management.entities.student.Batch;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Add this
public class ResultPublished extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // Add this
    private Batch batchName;

    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // Add this
    private ExamType examType;

    @Column(nullable = false)
    private LocalDate date;

    private Boolean status;  // Published status
}


