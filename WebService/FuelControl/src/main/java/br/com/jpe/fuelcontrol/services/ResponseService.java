/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service for dealing with responses
 *
 * @author joaovperin
 */
@Service
public class ResponseService {

    @Autowired
    private HttpServletResponse response;

    /**
     * Adds a header at the response
     *
     * @param headerName
     * @param value
     */
    public void addHeader(String headerName, String value) {
        response.addHeader(headerName, value);
    }

}
