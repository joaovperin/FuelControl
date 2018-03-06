/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.interceptors;

import br.com.jpe.fuelcontrol.services.AuthService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Intercepts each request to deal with authentication
 */
@Component
public class AuthHandlerMapping extends HandlerInterceptorAdapter {

    /** Token */
    private static final String HEADER_TOKEN = "fuelcontrol-token";

    @Autowired
    private AuthService authService;

    /**
     * Called before handling each request
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HEADER_TOKEN);
        if (token != null) {
            // TODO: Check auth by the token
        }
        String user = request.getHeader("user");
        String pass = request.getHeader("pass");
        // If passed user and password, tries to login
        if (user != null && pass != null) {
            return authService.login(user, pass);
        }
        // TODO: Allow 
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

}