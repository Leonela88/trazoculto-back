package com.trazoculto.editorial.dto.response;

import com.trazoculto.editorial.entity.enums.State;

public record ProjectShortResponseDTO(Long id, String projectTitle, State state, String clientName) {

}
