package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Qtrs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class QtrsRepository {

    Utility util = new Utility();
    EntityManager em = util.getEm();

    public List<Qtrs> findAll(){
        TypedQuery<Qtrs> query = (TypedQuery<Qtrs>) em.createQuery("Select q from Qtrs q");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(q) from Qtrs q");
        return query.getSingleResult();
    }

    public Qtrs find(Integer id){
        return em.find(Qtrs.class, id);
    }

    public Qtrs create(Qtrs qtrs){
        em.persist(qtrs);
        return qtrs;
    }

    public void delete(Integer id){
        em.remove(em.getReference(Qtrs.class, id));
    }
}
