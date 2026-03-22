package com.trazoculto.editorial.dto.request;

import java.time.ZonedDateTime;

import com.trazoculto.editorial.entity.enums.State;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjectRegisterRequestDTO(

        @NotBlank(message = "Title is required, maximum 50 characters.") @Size(max = 50) String projectTitle,

        @NotBlank(message = "Description required, maximum 250 characters.") @Size(max = 250) String projectDescription,

        @NotNull(message = "Please select a state") State state,

        @Size(max = 1000, message = "Notes cannot exceed 1000 characters") String notes,

        @Future(message = "The date canoot be past") ZonedDateTime dateOfSubmission

) {
}
