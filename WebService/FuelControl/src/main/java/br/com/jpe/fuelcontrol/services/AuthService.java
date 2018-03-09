/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import br.com.jpe.fuelcontrol.repository.UserLogin;
import br.com.jpe.fuelcontrol.repository.Usuario;
import br.com.jpe.fuelcontrol.dao.UserDAO;
import br.com.jpe.fuelcontrol.dao.UserLoginDAO;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Service for authentication purposes
 *
 * @author joaovperin
 */
@Service
@ApplicationScope
public class AuthService {

    /** Expiration time in seconds */
    private static final int LOGIN_EXP_TIME = 60;

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserLoginDAO userLoginDAO;
    @Autowired
    private DateService dateService;

    /**
     * Validates an user and login if it's credencials are right
     *
     * @param username
     * @param password
     * @return boolean True if successfull logged in
     *
     * @throws br.com.jpe.fuelcontrol.services.AuthException
     */
    public String login(String username, String password) throws AuthException {
        Usuario user = getUserOnDatabase(username);
        if (user == null || !user.getSenha().equals(password)) {
            throw new AuthException();
        }
        // Login logic
        String token = UUID.randomUUID().toString();
        user.getUserLogin().setLastLogin(new Date());
        user.getUserLogin().setToken(token);
        userDAO.update(user);
        return token;
    }

    /**
     * Validates an user and logout if it's credencials are right
     *
     * @param username
     * @param password
     * @throws br.com.jpe.fuelcontrol.services.AuthException
     */
    public void logout(String username, String password) throws AuthException {
        Usuario user = getUserOnDatabase(username);
        if (user == null || !user.getSenha().equals(password)) {
            throw new AuthException();
        }
        // Logout logic
        user.getUserLogin().setLastLogin(null);
        user.getUserLogin().setToken(null);
        userDAO.update(user);
    }

    /**
     * Returns true if the token is Valid
     *
     * @param token
     * @return boolean
     */
    public boolean isValidToken(String token) {
        UserLogin userLogin = userLoginDAO.searchByToken(token);
        if (userLogin == null) {
            return false;
        }
        // Checks if the last login is after the expiration time
        Date lastLogin = userLogin.getLastLogin();
        return lastLogin != null && dateService.isBefore(new Date(),
                dateService.addSeconds(lastLogin, LOGIN_EXP_TIME));
    }

    /**
     * Find and returns an user by his username
     *
     * @param username
     * @return Usuario
     */
    private Usuario getUserOnDatabase(String username) {
        if (username == null) {
            return null;
        }
        return userDAO.readKey(username.toLowerCase());
    }

}
