package com.trazoculto.editorial.service;

import org.springframework.stereotype.Service;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.entity.Client;
import com.trazoculto.editorial.entity.EditingService;
import com.trazoculto.editorial.entity.Project;
import com.trazoculto.editorial.mapper.ProjectMapper;
import com.trazoculto.editorial.repository.ClientRepository;
import com.trazoculto.editorial.repository.EditingServiceRepository;
import com.trazoculto.editorial.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final EditingServiceRepository editingServiceRepository;
    private ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ClientRepository clientRepository,
            EditingServiceRepository editingServiceRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
        this.editingServiceRepository = editingServiceRepository;
        this.projectMapper=projectMapper;
    }

    @Override
    public ProjectRegisteredResponseDTO createProject(ProjectRegisterRequestDTO dto) {

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not founded"));

        EditingService service = editingServiceRepository.findById(dto.editingServiceId())
                .orElseThrow(() -> new EntityNotFoundException("Service not founded"));

        Project project = projectMapper.toCreate(dto);
        project.setClient(client);
        project.setEditingService(service);

        Project savedProject = projectRepository.save(project);

        return projectMapper.toResponse(savedProject);
    }

}
