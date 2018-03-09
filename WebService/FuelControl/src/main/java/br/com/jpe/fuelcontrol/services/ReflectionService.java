/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.lang.reflect.Method;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.method.HandlerMethod;

/**
 * A simplifier for using Reflection
 *
 * @author joaovperin
 */
@Service
@ApplicationScope
public class ReflectionService {

    /**
     * Returns True if a handlermethod of a controller has an annotation
     *
     * @param handlerMethod
     * @param anottation
     * @return boolean
     */
    public boolean hasAnnotation(HandlerMethod handlerMethod, Class anottation) {
        Method method = handlerMethod.getMethod();
        if (method.getDeclaringClass().isAnnotationPresent(Controller.class)) {
            if (method.isAnnotationPresent(anottation)) {
                return true;
            }
        }
        return false;
    }

}
