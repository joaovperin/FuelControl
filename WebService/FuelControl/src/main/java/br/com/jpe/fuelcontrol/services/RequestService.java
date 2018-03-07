/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service for dealing with requests
 *
 * @author joaovperin
 */
@Service
public class RequestService {

    /** Inicial size of the Stringbuffer */
    private static final int SB_START_SIZE = 1024;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JsonService jsonService;

    /**
     * Returns the request body as a String
     *
     * @return String
     */
    public String getBody() {
        StringBuilder sb = new StringBuilder(SB_START_SIZE);
        try (BufferedReader reader = request.getReader()) {
            String l;
            while ((l = reader.readLine()) != null) {
                sb.append(l);
            }
        } catch (IOException e) {
            throw new InvalidParameterException("Invalid param on request.");
        }
        return sb.toString();
    }

    /**
     * Returns the request body cast as a class instance
     *
     * @param <T> type
     * @param type
     * @return String
     */
    public <T> T castBodyTo(Class<T> type) {
        return jsonService.castTo(getBody(), type);
    }

}
