package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Complainttype;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ComplaintTypeRepository {

    Utility util = new Utility();
    EntityManager em = util.getEm();

    public List<Complainttype> findAll(){
        TypedQuery<Complainttype> query = (TypedQuery<Complainttype>) em.createQuery("Select c from Complainttype c");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(c) from Complainttype c");
        return query.getSingleResult();
    }

    public Complainttype find(Integer id){
        return em.find(Complainttype.class, id);
    }

    @Transactional(REQUIRED)
    public Complainttype create(Complainttype complainttype){
        em.persist(complainttype);
        return complainttype;
    }

    @Transactional(REQUIRED)
    public void delete(Integer id){
        em.remove(em.getReference(Complainttype.class, id));
    }
}
