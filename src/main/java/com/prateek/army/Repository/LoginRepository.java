package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Login;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

public class LoginRepository {

    Utility util = new Utility();
    EntityManager em = util.getEm();

    public List<Login> findAll(){
        TypedQuery<Login> query = (TypedQuery<Login>) em.createQuery("Select l from Login l order by l.id desc");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(l) from Login l");
        return query.getSingleResult();
    }

    public Login find(Integer id){
        return em.find(Login.class, id);
    }

    @Transactional(REQUIRED)
    public Login create(Login login){
        em.persist(login);
        return login;
    }

    @Transactional(REQUIRED)
    public void delete(Integer id){
        em.remove(em.getReference(Login.class, id));
    }

}
