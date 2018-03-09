/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.beans.LoginBean;
import br.com.jpe.fuelcontrol.services.AuthException;
import br.com.jpe.fuelcontrol.services.AuthService;
import br.com.jpe.fuelcontrol.services.RequestService;
import br.com.jpe.fuelcontrol.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import br.com.jpe.fuelcontrol.anotattions.WebServiceAllowed;

/**
 * Controller for authentication methods
 *
 * @author Perin
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService auth;
    @Autowired
    private RequestService requestService;
    @Autowired
    private ResponseService responseService;

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
        if (auth.isValidToken(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    /**
     * Realize the Login on the WebService
     *
     * @return String
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    @WebServiceAllowed
    public ResponseEntity<Void> login() {
        LoginBean bean = requestService.castBodyTo(LoginBean.class);
        try {
            String token = auth.login(bean.getUser(), bean.getPass());
            responseService.addHeader("fuelcontrol-generated-token", token);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AuthException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
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
        try {
            auth.logout(user, pass);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AuthException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
