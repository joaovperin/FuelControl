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

    /**
     * Converts an Object to a JSON String
     *
     * @param object
     * @return String
     */
    public String toJson(Object object) {
        return g.toJson(object);
    }

    /**
     * Converts an Object to a JSON String
     *
     * @param object
     * @param clazz
     * @return String
     */
    public String toJson(Object object, Class clazz) {
        return g.toJson(object, clazz);
    }

    /**
     * Converts the JSON String to a instance of any class
     *
     * @param <T>
     * @param jsonString
     * @param type
     * @return T
     */
    public <T> T castTo(String jsonString, Class<T> type) {
        return g.fromJson(jsonString, type);
    }

}
