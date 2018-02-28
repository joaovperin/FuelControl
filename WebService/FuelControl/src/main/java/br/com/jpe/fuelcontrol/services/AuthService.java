/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import br.com.jpe.fuelcontrol.beans.User;
import br.com.jpe.fuelcontrol.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for authentication purposes
 *
 * @author joaovperin
 */
@Service
public class AuthService {

    @Autowired
    private UserDAO userDAO;

    /**
     * Validate an user and pass and returns true if its valid
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        User user = userDAO.getUser(username.toLowerCase());
        if (user != null && user.getPass().equals(password)) {
//            user.setLastLoginDate(new Date());
//            userDAO.update(user);
            // TODO: Update LAST LOGIN TIME on the UsersLogin table.
            return true;
        }
        return false;
    }

}
