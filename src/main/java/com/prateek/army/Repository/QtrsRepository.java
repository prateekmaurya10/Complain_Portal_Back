package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Qtrs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
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

    public List<Qtrs> findByArea(int id) {
        TypedQuery<Qtrs> query = (TypedQuery<Qtrs>) em.createQuery("Select q from Qtrs q where areaId="+id);
        return query.getResultList();
    }

    public Qtrs find(Integer id){
        return em.find(Qtrs.class, id);
    }

    @Transactional(REQUIRED)
    public Qtrs create(Qtrs qtrs){
        em.persist(qtrs);
        return qtrs;
    }

    @Transactional(REQUIRED)
    public void delete(Integer id){
        em.remove(em.getReference(Qtrs.class, id));
    }
}
