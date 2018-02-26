/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    /** Factory for connections */
    private final ConnFactory connFactory;

    public Auth(ConnFactory factory) {
        this.connFactory = factory;
    }

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
        try (Connection conn = connFactory.getConn()) {
            String sql = "SELECT User, Pass FROM Users WHERE User = ?";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setString(1, user);
                st.setString(2, pass);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        String userPassword = rs.getString(2);
                        return userPassword.equals(pass);
                    }
                }
            }
        } catch (SQLException ex) {
        }
        return false;
    }

}
