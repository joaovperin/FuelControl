/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for authentication methods
 *
 * @author Perin
 */
@Controller
public class AuthController {

    /** Auth service */
    @Autowired
    private AuthService auth;

    /**
     * The home page is just a Health indicator xD
     *
     * @return String
     */
    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Hello! I'm healthy :D", HttpStatus.OK);
    }

    /**
     * Realize the Login on the WebService
     *
     * @param user
     * @return String
     */
    @RequestMapping(value = {"/isLogged"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> login(String user) {
        if (auth.isLoggedIn(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    /**
     * Realize the Login on the WebService
     *
     * @param user
     * @param pass
     * @return String
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> login(String user, String pass) {
        boolean validCredentials = auth.login(user, pass);
        if (validCredentials) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Realize the Logout on the WebService
     *
     * @param user
     * @param pass
     * @return String
     */
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> logout(String user, String pass) {
        boolean validCredentials = auth.logout(user, pass);
        if (validCredentials) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
