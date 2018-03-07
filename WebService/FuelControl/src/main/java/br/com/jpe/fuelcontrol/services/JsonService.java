/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * A service to work with JSONs
 *
 * @author joaovperin
 */
@Service
@ApplicationScope
public class JsonService {

    @Autowired
    private Gson g;

    public Gson getGson() {
        return g;
    }

}
