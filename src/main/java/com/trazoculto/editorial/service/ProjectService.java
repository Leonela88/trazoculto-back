package com.trazoculto.editorial.service;

import java.util.List;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.request.ProjectUpdateRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.dto.response.ProjectShortResponseDTO;
import com.trazoculto.editorial.entity.enums.State;

public interface ProjectService {

    public ProjectRegisteredResponseDTO createProject(ProjectRegisterRequestDTO dto);

    List<ProjectShortResponseDTO> findAllProjects();

    List<ProjectShortResponseDTO> findByState(State state);

    List<ProjectShortResponseDTO> findAllSorted(String direction);

    ProjectRegisteredResponseDTO updateProject(Long id, ProjectUpdateRequestDTO dto);

    void deleteProject(Long id);
}
