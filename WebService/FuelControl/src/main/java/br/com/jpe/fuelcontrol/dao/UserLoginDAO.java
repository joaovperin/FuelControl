/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.dao;

import br.com.jpe.fuelcontrol.repository.UserLogin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * DAO for selecting User's Logins
 */
@Repository
public class UserLoginDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Return an UserLogin by his token or null if not found
     *
     * @param token
     * @return UserLogin
     */
    public UserLogin searchByToken(String token) {
        String hql = "FROM Usuarios_Login AS ul WHERE ul.token = ?";
        List<UserLogin> list = entityManager.createQuery(hql).setParameter(1, token).getResultList();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

}
