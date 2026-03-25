package com.trazoculto.editorial.service;

import java.util.List;

import com.trazoculto.editorial.dto.request.ClientRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ClientRegisterResponseDTO;

public interface ClientService {

    List<ClientRegisterResponseDTO> getAllClients();
    
    public ClientRegisterResponseDTO clientRegister(ClientRegisterRequestDTO dto);

    public void deleteClient(Long id);

}
