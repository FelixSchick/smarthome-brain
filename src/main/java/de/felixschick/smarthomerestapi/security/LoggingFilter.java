package de.felixschick.smarthomerestapi.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        String ipAddress = request.getRemoteAddr();
        String action = request.getMethod() + " " + request.getRequestURI();
        System.out.println("Log:  IP: " + ipAddress + " Action: " + action);
        filterChain.doFilter(request, response);
    }
}