package com.example.rentcarspring.security;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        if (!request.getMethod().equals("POST"))
            throw new AuthenticationServiceException("Metodo di autenticazione non supportato");
        UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = obtainPassword(request);

        email = (email == null) ? "" : email;
        password = (password == null) ? "" : password;

        return new UsernamePasswordAuthenticationToken(email, password);
    }


}
