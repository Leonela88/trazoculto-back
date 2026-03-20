package com.trazoculto.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trazoculto.editorial.entity.Project;

public interface ProjectRepository  extends JpaRepository<Project, Long>{

}
