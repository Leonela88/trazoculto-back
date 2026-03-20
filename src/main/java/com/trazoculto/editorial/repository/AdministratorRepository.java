package com.trazoculto.editorial.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trazoculto.editorial.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

    Optional<Administrator>findByEmail(String email);
}
