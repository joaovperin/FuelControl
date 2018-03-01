/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import br.com.jpe.fuelcontrol.beans.Usuario;
import br.com.jpe.fuelcontrol.dao.UserDAO;
import java.util.Date;
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
    private DateService dateService;

    /**
     * Validates an user and login if it's credencials are right
     *
     * @param username
     * @param password
     * @return boolean True if successfull logged in
     */
    public boolean login(String username, String password) {
        Usuario user = getUserOnDatabase(username);
        if (user == null || !user.getSenha().equals(password)) {
            return false;
        }
        // Login logic
        user.getUserLogin().setLastLogin(new Date());
        userDAO.update(user);
        return true;
    }

    /**
     * Validates an user and logout if it's credencials are right
     *
     * @param username
     * @param password
     * @return boolean True if successfull logged in
     */
    public boolean logout(String username, String password) {
        Usuario user = getUserOnDatabase(username);
        if (user == null || !user.getSenha().equals(password)) {
            return false;
        }
        // Logout logic
        user.getUserLogin().setLastLogin(null);
        userDAO.update(user);
        return true;
    }

    /**
     * Returns true if the user is logged in
     *
     * @param username
     * @return boolean
     */
    public boolean isLoggedIn(String username) {
        Usuario user = getUserOnDatabase(username);
        if (user == null) {
            return false;
        }
        // Checks if the last login is after the expiration time
        Date lastLogin = user.getUserLogin().getLastLogin();
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
