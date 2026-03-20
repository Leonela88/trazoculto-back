package com.trazoculto.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trazoculto.editorial.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
