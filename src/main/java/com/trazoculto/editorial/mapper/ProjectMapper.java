package com.trazoculto.editorial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.entity.Project;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
     @Mapping(source="clientId", target ="client.id")
     @Mapping(source="editingServiceId", target ="editingService.id")
     Project toCreate(ProjectRegisterRequestDTO dto);

     @Mapping(source="client.id", target = "clientId")
     @Mapping(source="editingService.id", target = "editingServiceId")
    ProjectRegisteredResponseDTO toResponse(Project project);
     
}

