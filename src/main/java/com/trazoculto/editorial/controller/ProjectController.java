package com.trazoculto.editorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trazoculto.editorial.dto.request.ProjectRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ProjectRegisteredResponseDTO;
import com.trazoculto.editorial.service.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
  public ResponseEntity<ProjectRegisteredResponseDTO>create (@RequestBody ProjectRegisterRequestDTO dto){
    return ResponseEntity.ok(projectService.createProject(dto));
  }
    

}
