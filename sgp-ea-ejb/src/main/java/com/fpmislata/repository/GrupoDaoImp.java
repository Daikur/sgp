/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class GrupoDaoImp implements GrupoDaoImpLocal {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    
    @Override
    public List listGrupos() {
        List a = em.createNamedQuery("Grupo.findAll").getResultList();
        return a;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
