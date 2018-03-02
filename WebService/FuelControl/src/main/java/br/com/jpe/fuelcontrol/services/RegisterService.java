/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import br.com.jpe.fuelcontrol.beans.Register;
import br.com.jpe.fuelcontrol.dao.RegisterDAO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joaovperin
 */
@Service
public class RegisterService {

    @Autowired
    private RegisterDAO registerDAO;

    public long add(String user, String kmInicial, String kmFinal) {
        Register reg = new Register();
        reg.setUser(user);
        reg.setKmInicial(kmInicial);
        reg.setKmFinal(kmFinal);
        reg.setHoraEnvio(new Date());
        registerDAO.insert(reg);
        return reg.getId();
    }

    public List<Register> getAllFor(String user) {
        return registerDAO.getAllForUser(user);
    }

    public List<Register> getAll() {
        return registerDAO.getAll();
    }

}
