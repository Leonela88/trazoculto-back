package com.trazoculto.editorial.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.request.ProjectUpdateRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.dto.response.ProjectShortResponseDTO;
import com.trazoculto.editorial.entity.Client;
import com.trazoculto.editorial.entity.EditingService;
import com.trazoculto.editorial.entity.Project;
import com.trazoculto.editorial.entity.enums.State;
import com.trazoculto.editorial.mapper.ProjectMapper;
import com.trazoculto.editorial.repository.ClientRepository;
import com.trazoculto.editorial.repository.EditingServiceRepository;
import com.trazoculto.editorial.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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
        this.projectMapper = projectMapper;
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

    @Override
    public List<ProjectShortResponseDTO> findAllProjects() {

        List<Project> projects = projectRepository.findAll();

        return projectMapper.toShortResponseList(projects);
    }

    @Override
    public List<ProjectShortResponseDTO> findByState(State state) {
        List<Project> projects = projectRepository.findByState(state);
        return projectMapper.toShortResponseList(projects);
    }

    @Override
    public List<ProjectShortResponseDTO> findAllSorted(String direction) {

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by("createdAt").ascending()
                : Sort.by("createdAt").descending();

        List<Project> projects = projectRepository.findAll(sort);
        return projectMapper.toShortResponseList(projects);
    }

    @Override
    @Transactional
    public ProjectRegisteredResponseDTO updateProject(Long id, ProjectUpdateRequestDTO dto) {
        Project project = projectRepository.findById(id)// BUSCAR EL PROYECTO
                .orElseThrow(() -> new EntityNotFoundException("Proyect not founded ID: " + id));

        projectMapper.updateEntityFromDto(dto, project);// ACTUALIZAR DATOS

        // ACTUALIZAR CLIENTE
        if (dto.clientId() != null) {
            Client client = clientRepository.findById(dto.clientId())
                    .orElseThrow(() -> new EntityNotFoundException("Client not founded"));
            project.setClient(client);
        }

        // 4. ACTUALIZAR SERVICIO
        if (dto.editingServiceId() != null) {
            EditingService service = editingServiceRepository.findById(Integer.valueOf(dto.editingServiceId()))
                    .orElseThrow(() -> new EntityNotFoundException("Service not founded"));
            project.setEditingService(service);
        }

        // GUARDAR Y DEVOLVER DTO RESPUESTA
        return projectMapper.toResponse(projectRepository.save(project));
    }

    @Override
    @Transactional
    public void deleteProject(Long id) {
       
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete: The project with ID : " + id + " doesnt exists.");
        }
        projectRepository.deleteById(id);
    }
}
