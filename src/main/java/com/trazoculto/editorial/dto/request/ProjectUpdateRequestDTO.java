package com.trazoculto.editorial.dto.request;

import java.time.LocalDate;

import com.trazoculto.editorial.entity.enums.State;

public record ProjectUpdateRequestDTO(String projectTitle, 
    String projectDescription, 
    State state, 
    String notes,
    LocalDate dateOfSubmission,
    Long clientId,
    Integer editingServiceId
) {

}
