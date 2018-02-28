/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity that represents an User
 */
@Entity(name = "usuarios")
@Table(name = "usuarios")
public class User implements Serializable {

    @Id
    @Column(name = "Usuario")
    private String user;
    @Column(name = "Senha")
    private String pass;
    @OneToOne
    private UserLogin userLogin;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

//    public void setLastLoginDate(Date date) {
//        getUserLogin().setLastLogin(date);
//    }
//
//    public Date getLastLoginDate() {
//        return getUserLogin().getLastLogin();
//    }
}
