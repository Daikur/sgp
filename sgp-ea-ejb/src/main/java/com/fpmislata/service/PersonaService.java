package com.fpmislata.service;

import com.fpmislata.domain.Persona;
import com.fpmislata.repository.PersonaDaoImpLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersonaService implements PersonaServiceLocal {
    
    @EJB
    private PersonaDaoImpLocal personaDao;
    
    @Override
    public void addPersona(Persona persona) {
//        // Recorremos la lista comprobando que la persona no existe
//        Iterator<Persona> it = lista.iterator();
//        boolean enc = false;
//        
//        while ((it.hasNext()) && (enc == false)) {
//            if (it.next().getId() == persona.getId()) {
//                enc = true;
//            }
//        }
//        // Si la persona no existe la añadimos a la lista
//        if (enc == false) {
//            persona.setId(lastId);
//            lastId++;
//            lista.add(persona);
//        }
        personaDao.addPersona(persona);
    }
    
    @Override
    public void updatePersona(Persona persona) {
//         Recorremos la lista comprobando que la persona no existe
//        boolean enc = false;
//        int i = 0;
//
//        while ((i < lista.size()) && (enc == false)) {
//            if (lista.get(i).getId() == persona.getId()) {
//                enc = true;
//            } else {
//                i++;
//            }
//        }
//         Si la persona existe, tenemos el indice a modificar 
//         por lo que realizamos la actualizacion
//        if (enc == true) {
//            lista.set(i, persona);
//        }
        personaDao.updatePersona(persona);
    }
    
    @Override
    public Persona findPersonaById(Persona persona) {
//         Recorremos la lista buscando la persona
//        Iterator<Persona> it = lista.iterator();
//
//        while (it.hasNext()) {
//            Persona p = it.next();
//            if (p.getId() == persona.getId()) {
//                return p;
//            }
//        }
//        return null;
        return personaDao.findPersonaById(persona);
    }
    
    @Override
    public void deletePersona(Persona persona) {
//        // Recorremos la lista buscando la persona
//        boolean enc = false;
//        int i=0;
//        
//        while((i<lista.size())&&(enc==false)){
//            if(lista.get(i).getId()==persona.getId()){
//                enc=true;                
//            }else{
//                i++;
//            }
//        }
//        // Si la persona existe, tenemos el indice borrar
//        if(enc==true){
//            lista.remove(i);
//        }
        personaDao.deletePersona(persona);
    }
    
    @Override
    public List listPersonas() {
        return personaDao.listPersonas();
    }
    
}
