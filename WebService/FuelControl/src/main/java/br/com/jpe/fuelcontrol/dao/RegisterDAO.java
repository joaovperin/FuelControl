/*
 * fuel-control
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.jpe.fuelcontrol.dao;

import br.com.jpe.fuelcontrol.beans.Register;
import java.util.Date;
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

    public Register get(String user, Date date) {
        return entityManager.find(Register.class, new Register.Pk(user, date));
    }

    public List<Register> getAll() {
        String hql = "FROM registros rg ORDER BY rg.Usuario";
        return entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    public void insert(Register user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(Register reg) {
        Register usr = get(reg.getUser(), reg.getHoraEnvio());
        entityManager.flush();
    }

    @Transactional
    public void delete(String user, Date date) {
        entityManager.remove(get(user, date));
    }

    public boolean exists(String user, Date date) {
        String hql = "FROM registros as rg WHERE rg.Usuario = ? AND rg.HoraEnvio = ?";
        int count = entityManager.createQuery(hql).setParameter(1, user)
                .setParameter(2, date).getResultList().size();
        return count > 0;
    }
}
