/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.controllers;

import br.com.jpe.fuelcontrol.beans.Register;
import br.com.jpe.fuelcontrol.services.RegisterService;
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

/**
 * A controller for the register entity
 *
 * @author joaovperin
 */
@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public ResponseEntity<List> getAll() {
        List<Register> list = registerService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{user}")
    public ResponseEntity get(@PathVariable String user) {
        List<Register> list = registerService.getAllFor(user);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> add(String user, String kmInicial, String kmFinal) {
        long id = registerService.add(user, kmInicial, kmFinal);
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
