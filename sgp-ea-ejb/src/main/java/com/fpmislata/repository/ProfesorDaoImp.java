package com.fpmislata.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProfesorDaoImp implements ProfesorDaoImpLocal {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    
    @Override
    public List listProfesores() {
        List a = em.createNamedQuery("Profesor.findAll").getResultList();
        return a;
    }
}
