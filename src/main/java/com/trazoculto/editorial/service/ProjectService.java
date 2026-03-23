package com.trazoculto.editorial.service;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;

public interface ProjectService {

    public ProjectRegisteredResponseDTO createProject(ProjectRegisterRequestDTO dto);

}
