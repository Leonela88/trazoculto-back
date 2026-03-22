package com.trazoculto.editorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.trazoculto.editorial.entity.Client;

class ClientTest {

    @Test
    void shouldCreateClient() {
       
        Client client = new Client();
        
        
        client.setName("Vera");
        client.setEmail("veraluzramirez@mail.com");

        
        assertNotNull(client);
        assertEquals("Vera", client.getName());
        assertEquals("veraluzramirez@mail.com", client.getEmail());
    }
}