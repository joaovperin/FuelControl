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
     * @param user
     * @param pass
     * @return boolean
     */
    public boolean login(String user, String pass) {
        if (user == null || pass == null) {
            return false;
        }
        User x = userDAO.getUser(user.toLowerCase());
        return x == null ? false : x.getPass().equals(pass);
    }

}
