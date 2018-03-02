/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.dao;

import br.com.jpe.fuelcontrol.beans.Register;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO for selecting Registers
 */
@Repository
public class RegisterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Register get(long idRegister) {
        return entityManager.find(Register.class, idRegister);
    }

    public List<Register> getAll() {
        return entityManager.createQuery("SELECT r FROM registros r")
                .setMaxResults(10)
                .getResultList();
    }

    public List<Register> getAllForUser(String user) {
        return entityManager.createQuery("SELECT r FROM registros r WHERE r.user LIKE :user")
                .setParameter("user", user)
                .getResultList();
    }

    @Transactional
    public void insert(Register user) {
        entityManager.persist(user);
    }

    @Transactional
    public void delete(long idRegister) {
        entityManager.remove(get(idRegister));
    }

}
