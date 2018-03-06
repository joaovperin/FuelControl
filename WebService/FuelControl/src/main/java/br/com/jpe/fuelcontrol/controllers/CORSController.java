/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Cross Origin Requests
 *
 * @author Perin
 */
@Controller
public class CORSController {

    /**
     * Accepts all CORS requests
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "*", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> home() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
