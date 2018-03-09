/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.anotattions.WebServiceAllowed;
import br.com.jpe.fuelcontrol.services.AdvertisementGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for ADS :D
 *
 * @author joaovperin
 */
@Controller
public class AdController {

    @Autowired
    private AdvertisementGeneratorService adService;

    @RequestMapping("/ad")
    @ResponseBody
    @WebServiceAllowed
    public ResponseEntity<String> newAd() {
        return new ResponseEntity<>(adService.randomAd(), HttpStatus.OK);
    }

}
