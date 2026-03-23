package com.trazoculto.editorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trazoculto.editorial.entity.Project;
import com.trazoculto.editorial.entity.enums.State;

public interface ProjectRepository  extends JpaRepository<Project, Long>{
    List<Project> findByState(State state);
}
