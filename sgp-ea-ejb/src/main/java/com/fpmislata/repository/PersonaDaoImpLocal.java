package com.fpmislata.repository;

import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaDaoImpLocal {

    void addPersona(Persona persona);

    void updatePersona(Persona persona);

    Persona findPersonaById(Persona persona);

    Persona findPersonaByEmail(Persona persona);

    void deletePersona(Persona persona);

    List listPersonas();
    
}
