/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.beans;

import java.io.Serializable;

/**
 * A bean that represents a Return Message
 *
 * @author joaovperin
 */
public class ReturnMessage implements Serializable {

    /** Http status code */
    private int httpCode;
    /** A message to the client */
    private String message;
    /** The stack trace if its caused by an exception */
    private String stackTrace;

    public ReturnMessage() {
    }

    public ReturnMessage(String message) {
        this.httpCode = 200;
        this.message = message;
        this.stackTrace = null;
    }

    public ReturnMessage(Throwable ex) {
        this.httpCode = 500;
        this.message = ex.getMessage();
        final StringBuilder sb = new StringBuilder(2048);
        for (StackTraceElement s : ex.getStackTrace()) {
            sb.append(s);
        }
        this.stackTrace = sb.toString();
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

}
