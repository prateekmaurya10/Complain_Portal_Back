package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Complaintrecords;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class ComplaintRecordsRepository {

    Utility util = new Utility();
    EntityManager em = util.getEm();

    public List<Complaintrecords> findAll(){
        TypedQuery<Complaintrecords> query = (TypedQuery<Complaintrecords>) em.createQuery("Select c from Complaintrecords c");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(c) from Complaintrecords c");
        return query.getSingleResult();
    }

    public Complaintrecords find(Integer id){
        return em.find(Complaintrecords.class, id);
    }

    @Transactional(REQUIRED)
    public Complaintrecords create(Complaintrecords complaintrecords){
        em.getTransaction().begin();
        em.persist(complaintrecords);
        em.getTransaction().commit();
        return complaintrecords;
    }

    @Transactional(REQUIRED)
    public void delete(Integer id){
        em.remove(em.getReference(Complaintrecords.class, id));
    }
}
