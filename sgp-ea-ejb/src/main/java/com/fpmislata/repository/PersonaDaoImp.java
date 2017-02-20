package com.fpmislata.repository;

import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonaDaoImp implements PersonaDaoImpLocal {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public void addPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getId());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona p where p.email = :email");
        query.setParameter("email", persona.getEmail());
        try {
            return (Persona) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (NonUniqueResultException nur) {
            return (Persona) query.getResultList().get(0);
        }
    }

    @Override
    public void deletePersona(Persona persona) {
        persona = findPersonaById(persona);
        em.remove(persona);
    }

    @Override
    public List listPersonas() {
        List a = em.createNamedQuery("Persona.findAll").getResultList();
        return a;
    }

}