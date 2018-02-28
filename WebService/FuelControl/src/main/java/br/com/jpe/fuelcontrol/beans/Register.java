/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity that represents a Register
 */
@Entity
@Table(name = "Registros")
public class Register implements Serializable {

    @Id
    @Column(name = "Usuario")
    private String user;
    @Id
    @Column(name = "HoraEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEnvio;
    @Column(name = "KmInicial")
    private String kmInicial;
    @Column(name = "KmFinal")
    private String kmFinal;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Date horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public String getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(String kmInicial) {
        this.kmInicial = kmInicial;
    }

    public String getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(String kmFinal) {
        this.kmFinal = kmFinal;
    }

    public static class Pk {

        public String user;
        public Date horaEnvio;

        public Pk(String user, Date horaEnvio) {
            this.user = user;
            this.horaEnvio = horaEnvio;
        }

    }

}
