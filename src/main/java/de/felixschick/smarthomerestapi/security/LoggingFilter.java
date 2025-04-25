package de.felixschick.smarthomerestapi.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        String ipAddress = request.getRemoteAddr();
        String action = request.getMethod() + " " + request.getRequestURI();
        logger.info("Log:  IP: " + ipAddress + " Action: " + action);
        filterChain.doFilter(request, response);
    }
}