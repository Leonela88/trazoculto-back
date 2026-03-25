package com.trazoculto.editorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trazoculto.editorial.dto.request.ClientRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ClientRegisterResponseDTO;
import com.trazoculto.editorial.service.ClientService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @PostMapping("/register")
    public ResponseEntity<ClientRegisterResponseDTO> createClient(@RequestBody ClientRegisterRequestDTO dto) {
        ClientRegisterResponseDTO response = clientService.clientRegister(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ClientRegisterResponseDTO>> getAll() {
        List<ClientRegisterResponseDTO> response = clientService.getAllClients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
