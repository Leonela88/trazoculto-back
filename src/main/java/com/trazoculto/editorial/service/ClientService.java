package com.trazoculto.editorial.service;

import com.trazoculto.editorial.dto.ClientRegisterRequestDTO;
import com.trazoculto.editorial.dto.ClientRegisterResponseDTO;

public interface ClientService {

    public ClientRegisterResponseDTO clientRegister(ClientRegisterRequestDTO dto);

    public void deleteClient(Long id);

}
