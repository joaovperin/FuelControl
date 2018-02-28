/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.dao;

import br.com.jpe.fuelcontrol.beans.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO for selecting Users
 */
@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public User getUser(String user) {
        return entityManager.find(User.class, user);
    }

    public List<User> getAllUsers() {
        String hql = "FROM Usuarios as us ORDER BY us.Usuario";
        return entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    public void addArticle(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user) {
        User usr = getUser(user.getUser());
        usr.setPass(user.getPass());
        entityManager.flush();
    }

    @Transactional
    public void delete(String user) {
        entityManager.remove(getUser(user));
    }

    public boolean exists(String user) {
        String hql = "FROM Usuarios as us WHERE us.Usuario = ?";
        int count = entityManager.createQuery(hql).setParameter(1, user)
                .getResultList().size();
        return count > 0;
    }
}
