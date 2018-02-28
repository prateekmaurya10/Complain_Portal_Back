package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Area;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class AreasRepository {

    Utility util = new Utility();
    EntityManager em = util.getEm();

    public List<Area> findAll(){
        TypedQuery<Area> query = (TypedQuery<Area>) em.createQuery("Select a from Area a");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(a) from Area a");
        return query.getSingleResult();
    }

    public Area find(Integer id){
        return em.find(Area.class, id);
    }

    @Transactional(REQUIRED)
    public Area create(Area area){
        em.persist(area);
        return area;
    }

    @Transactional(REQUIRED)
    public void delete(Integer id){
        em.remove(em.getReference(Area.class, id));
    }
}
