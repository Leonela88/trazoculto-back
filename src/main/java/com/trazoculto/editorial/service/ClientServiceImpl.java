package com.trazoculto.editorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trazoculto.editorial.dto.request.ClientRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ClientRegisterResponseDTO;
import com.trazoculto.editorial.entity.Client;
import com.trazoculto.editorial.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientRegisterResponseDTO clientRegister(ClientRegisterRequestDTO dto) {

        clientRepository.findByEmail(dto.email())
                .ifPresent(client -> {
                    throw new RuntimeException("The email" + dto.email() + " is already registered.");
                });

        Client client = new Client();
        client.setName(dto.name());
        client.setEmail(dto.email());

        Client savedClient = clientRepository.save(client);

        return new ClientRegisterResponseDTO(
                savedClient.getId(),
                savedClient.getName(),
                savedClient.getEmail());

    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientRegisterResponseDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(client -> new ClientRegisterResponseDTO(
                        client.getId(),
                        client.getName(),
                        client.getEmail()))
                .toList();
    }

}
