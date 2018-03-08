/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Entity that represents an UserLogin
 */
@Entity
@Table(name = "usuarios_login", uniqueConstraints = {
    @UniqueConstraint(columnNames = "token") })
public class UserLogin implements Serializable {

    @Id
    @Column(name = "usuario")
    private String usuarioLogado;

    @Column(name = "token", unique = true, nullable = true)
    private String token;

    @Column(name = "hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userLogin")
    private Usuario myuser;

    /*
    CREATE TABLE IF NOT EXISTS `usuarios_login` (
  `usuario` varchar(40) NOT NULL,
  `token` varchar(40) NULL,
  `hora` TIMESTAMP NULL,
  PRIMARY KEY (`usuario`),
  INDEX `FK_Usuarios_Usuarios_Login_idx` (`usuario` ASC),
  UNIQUE INDEX `Chave_Token_Usuarios_Login_idx` (`token` ASC),
  CONSTRAINT `FK_Usuarios_Usuarios_Login`
    FOREIGN KEY (`usuario`)
    REFERENCES `usuarios` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE = utf8_general_ci;
     */
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
