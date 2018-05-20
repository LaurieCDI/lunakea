package com.mycompany.lunakea.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public abstract class AbstractPersistenceRepo {

    @PersistenceContext(unitName="lunakea-PU")
    EntityManager em;
}
