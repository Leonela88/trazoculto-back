package com.trazoculto.editorial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trazoculto.editorial.entity.Administrator;
import com.trazoculto.editorial.repository.AdministratorRepository;

@Service
public class UserDetail implements UserDetailsService{
    
    @Autowired
    private  AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Administrator admin = administratorRepository.findByEmail(email)
        .orElseThrow(()-> new UsernameNotFoundException("Admin not found with email: " + email));

        return User.builder()
                .username(admin.getEmail()) 
                .password(admin.getPassword())
                .roles("ADMIN")
                .build();
    }

}
