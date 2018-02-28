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
 * Entity that represents an UserLogin
 */
@Entity(name = "usuarios_login")
@Table(name = "usuarios_login")
public class UserLogin implements Serializable {

    @Id
    @Column(name = "Usuario")
    private String usuario;
    @Column(name = "HoraUltimoLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
