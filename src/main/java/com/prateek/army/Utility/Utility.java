package com.prateek.army.Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.
            createEntityManagerFactory("ComplaintPortalPU");

    private EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

    public EntityManager getEm() {
        return em;
    }
}
