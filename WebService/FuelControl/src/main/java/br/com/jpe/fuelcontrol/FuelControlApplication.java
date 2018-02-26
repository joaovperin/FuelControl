/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.*;

/**
 * Main class of the Application, responsible for config and start
 *
 * @author Perin
 */
@SpringBootApplication
@EnableAutoConfiguration
public class FuelControlApplication {

    /**
     * Runs the app
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FuelControlApplication.class, args);
    }

}
