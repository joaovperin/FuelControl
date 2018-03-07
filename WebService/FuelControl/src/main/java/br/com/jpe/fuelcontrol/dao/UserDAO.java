/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.dao;

import br.com.jpe.fuelcontrol.repository.Usuario;
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

    public Usuario readKey(String user) {
        return entityManager.find(Usuario.class, user);
    }

    public List<Usuario> select() {
        String hql = "FROM Usuarios as us ORDER BY us.Usuario";
        return entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    public void insert(Usuario user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(Usuario user) {
        Usuario usr = readKey(user.getUsuario());
        usr.setSenha(user.getSenha());
        entityManager.flush();
    }

    @Transactional
    public void delete(String user) {
        entityManager.remove(readKey(user));
    }

    public long count() {
        String hql = "FROM Usuarios";
        int count = entityManager.createQuery(hql).getResultList().size();
        return count;
    }

    public boolean exists(String user) {
        String hql = "FROM Usuarios as us WHERE us.Usuario = ?";
        int count = entityManager.createQuery(hql).setParameter(1, user)
                .getResultList().size();
        return count > 0;
    }
}
