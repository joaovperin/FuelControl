/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.anotattions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for methods that doesn't needs auth to access
 *
 * @author joaovperin
 */
@Target(value = { ElementType.METHOD, ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface WebServiceAllowed {

}
