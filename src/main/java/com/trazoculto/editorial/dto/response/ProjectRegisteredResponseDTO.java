package com.trazoculto.editorial.dto.response;

import java.time.ZonedDateTime;

import com.trazoculto.editorial.entity.enums.State;

public record ProjectRegisteredResponseDTO(
        Long id, String projectTitle, String projectDescription, State state, String notes,
        ZonedDateTime dateOfSubmission) {

}
