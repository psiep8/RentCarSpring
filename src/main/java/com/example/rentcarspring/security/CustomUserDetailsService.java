package com.example.rentcarspring.security;

import com.example.rentcarspring.entity.Utente;
import com.example.rentcarspring.service.UtenteService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UtenteService utenteService;

    public CustomUserDetailsService(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Utente utente = utenteService.getUserByEmail(mail);
        if (utente == null) {
            throw new UsernameNotFoundException("Utente non trovato!");
        }
        User.UserBuilder builder = User.withUsername(utente.getEmail());
        builder.password(utente.getPassword());
        if (utente.isCustomer()) {
            builder.roles("USER");
        } else builder.roles("ADMIN");

        return builder.build();
    }
}
