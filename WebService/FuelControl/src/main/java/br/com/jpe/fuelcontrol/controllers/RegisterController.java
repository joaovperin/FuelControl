/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.anotattions.WebServiceAllowed;
import br.com.jpe.fuelcontrol.repository.Register;
import br.com.jpe.fuelcontrol.services.RegisterService;
import br.com.jpe.fuelcontrol.services.RequestService;
import br.com.jpe.fuelcontrol.services.ResponseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A controller for the register entity
 *
 * @author joaovperin
 */
@Controller
@RequestMapping("register")
@WebServiceAllowed // TODO: Remove after tests.
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private ResponseService responseService;

    /**
     * Read and return all the registers from the database
     *
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List> getAll() {
        List<Register> list = registerService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Reads and return registers for one user
     *
     * @param user
     * @return ResponseEntity
     */
    @GetMapping("/{user}")
    public ResponseEntity get(@PathVariable String user) {
        List<Register> list = registerService.getAllFor(user);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Adds one register on the database
     *
     * @return ResponseEntity
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> add() {
        Register bean = requestService.castBodyTo(Register.class);
        long id = registerService.add(bean);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody String user) {
        return new ResponseEntity<>(user, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
