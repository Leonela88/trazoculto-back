package com.trazoculto.editorial.service;

import com.trazoculto.editorial.dto.request.ClientRegisterRequestDTO;
import com.trazoculto.editorial.dto.response.ClientRegisterResponseDTO;

public interface ClientService {

    public ClientRegisterResponseDTO clientRegister(ClientRegisterRequestDTO dto);

    public void deleteClient(Long id);

}
