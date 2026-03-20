package com.trazoculto.editorial.entity;

import java.time.ZonedDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.trazoculto.editorial.entity.enums.State;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "projects")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Project {
 
    @Id
    @GeneratedValue(strategy = (GenerationType.IDENTITY))
    private Long id;

    @Column(length = 50)
    private String projectTitle;

    @Column(columnDefinition = "TEXT")
    private String projectDescription;
    
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @CreatedDate
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    private ZonedDateTime dateOfSubmission;
 
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "editing_service_id", nullable = false)
    private EditingService editingService;
}
