/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * A Simple Date Service
 *
 * @author joaovperin
 */
@Service
@ApplicationScope
public class DateService {

    /** How milliseconds it have in a second? */
    private static final int MILLISECONDS_IN_A_SECOND = 1000;

    /**
     * Returns true if the first date is before the second
     *
     * @param dtIni
     * @param dtFin
     * @return boolean
     */
    public boolean isBefore(Date dtIni, Date dtFin) {
        if (dtIni == null || dtFin == null) {
            return false;
        }
        return dtIni.getTime() < dtFin.getTime();
    }

    /**
     * Returns true if the first date is after the second
     *
     * @param dtIni
     * @param dtFin
     * @return boolean
     */
    public boolean isAfter(Date dtIni, Date dtFin) {
        return !isBefore(dtIni, dtFin);
    }

    /**
     * Creates a new Date Object adding some seconds to a Date
     *
     * @param dtIni
     * @param numSeconds
     * @return Date
     */
    public Date addSeconds(Date dtIni, int numSeconds) {
        if (dtIni == null) {
            return null;
        }
        return new Date(dtIni.getTime() + numSeconds * MILLISECONDS_IN_A_SECOND);
    }

}
