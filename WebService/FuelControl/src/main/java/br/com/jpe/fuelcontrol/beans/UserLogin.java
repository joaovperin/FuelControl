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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity that represents an UserLogin
 */
@Entity
@Table(name = "usuarios_login")
public class UserLogin implements Serializable {

    @Id
    @Column(name = "usuario")
    private String usuarioLogado;

    @Column(name = "token")
    private String token;

    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @OneToOne(mappedBy = "userLogin")
    private Usuario myuser;

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Usuario getMyuser() {
        return myuser;
    }

    public void setMyuser(Usuario myuser) {
        this.myuser = myuser;
    }

}
