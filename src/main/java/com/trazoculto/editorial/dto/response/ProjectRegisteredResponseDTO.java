package com.trazoculto.editorial.dto.response;




import java.time.LocalDate;

import com.trazoculto.editorial.entity.enums.State;

public record ProjectRegisteredResponseDTO(
        Long id, String projectTitle, String projectDescription, State state, String notes,
        Integer editingServiceId, Long clientId, LocalDate dateOfSubmission) {

}
