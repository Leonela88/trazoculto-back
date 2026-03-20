package com.trazoculto.editorial.entity;

import java.math.BigDecimal;

import com.trazoculto.editorial.entity.enums.ServiceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "editing_services")
@Data
@NoArgsConstructor
public class EditingService {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Enumerated(EnumType.STRING)
private ServiceType editingServiceType;

@Column(length = 250)
private String editingServiceDescription;

@PositiveOrZero 
@Column(precision = 10, scale= 2)
private BigDecimal price;

}
