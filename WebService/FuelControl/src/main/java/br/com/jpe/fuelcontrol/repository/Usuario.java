/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.repository;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity that represents an User
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuario")
    private UserLogin userLogin;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

}
