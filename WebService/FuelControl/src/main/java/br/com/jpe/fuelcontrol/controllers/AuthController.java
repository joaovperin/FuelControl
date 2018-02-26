/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for authentication methods
 *
 * @author Perin
 */
@Controller
public class AuthController {

    /**
     * Displays a Hello World message!
     *
     * @return String
     */
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}
