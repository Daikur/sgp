package com.fpmislata.service;

import com.fpmislata.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaServiceLocal {

    void addPersona(Persona persona);

    void updatePersona(Persona persona);

    Persona findPersonaById(Persona persona);

    void deletePersona(Persona persona);

    List listPersonas();
    
}
