/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Service for authentication purposes
 *
 * @author joaovperin
 */
@Service
public class Auth {

    /** Users cache (for testing purposes only) */
    private static final Map<String, String> USERS;

    static {
        USERS = new HashMap<>();
        USERS.put("admin", "admin");
        USERS.put("joao", "1234");
        USERS.put("carlos", "1234");
    }

    /**
     * Validate an user and pass and returns true if its valid
     *
     * @param user
     * @param pass
     * @return boolean
     */
    public boolean login(String user, String pass) {
        String userPassword = USERS.get(user.toLowerCase());
        if (userPassword != null) {
            return userPassword.equals(pass);
        }
        return false;
    }

}
