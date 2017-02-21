/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.repository.ProfesorDaoImpLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProfesorService implements ProfesorServiceLocal {

    @EJB
    private ProfesorDaoImpLocal profesorDao;

    @Override
    public List listProfesores() {
        return profesorDao.listProfesores();
    }

}
