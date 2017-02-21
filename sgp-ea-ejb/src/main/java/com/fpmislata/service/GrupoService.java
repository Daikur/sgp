/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.repository.GrupoDaoImpLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class GrupoService implements GrupoServiceLocal {

    @EJB
    private GrupoDaoImpLocal grupoDao;

    @Override
    public List listGrupos() {
        return grupoDao.listGrupos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
