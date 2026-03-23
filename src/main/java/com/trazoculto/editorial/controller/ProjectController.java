package com.trazoculto.editorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.request.ProjectUpdateRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.dto.response.ProjectShortResponseDTO;
import com.trazoculto.editorial.entity.enums.State;
import com.trazoculto.editorial.service.ProjectService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

  private final ProjectService projectService;

  @PostMapping
  public ResponseEntity<ProjectRegisteredResponseDTO> create(@RequestBody ProjectRegisterRequestDTO dto) {
    return ResponseEntity.ok(projectService.createProject(dto));
  }

  @GetMapping
  public ResponseEntity<List<ProjectShortResponseDTO>> getAll() {
    return ResponseEntity.ok(projectService.findAllProjects());
  }

  @GetMapping("/filter")
  public ResponseEntity<List<ProjectShortResponseDTO>> getByState(@RequestParam State state) {
    return ResponseEntity.ok(projectService.findByState(state));
  }

  @GetMapping("/sorted")
  public ResponseEntity<List<ProjectShortResponseDTO>> getAllSorted(
      @RequestParam(defaultValue = "desc") String direction) {
    return ResponseEntity.ok(projectService.findAllSorted(direction));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProjectRegisteredResponseDTO> update(
      @PathVariable Long id,
      @RequestBody ProjectUpdateRequestDTO dto) {
    return ResponseEntity.ok(projectService.updateProject(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    projectService.deleteProject(id);
    return ResponseEntity.noContent().build(); // Devuelve 204
  }
}
