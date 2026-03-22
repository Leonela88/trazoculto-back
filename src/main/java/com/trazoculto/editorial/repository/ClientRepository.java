package com.trazoculto.editorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trazoculto.editorial.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
}
