/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.services.AuthService;
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
    private final AuthService auth;

    /**
     * Dependency Injectable Controller
     *
     * @param auth
     */
    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    /**
     * Initial page
     *
     * @return String
     */
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "\"Hello :D\"";
    }

    /**
     * Realize the Login on the WebService
     *
     * @param user
     * @param pass
     * @return String
     */
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> login(String user, String pass) {
        boolean validLogin = auth.login(user, pass);
        if (validLogin) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
