/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Grupo;
import com.fpmislata.domain.Profesor;
import com.fpmislata.service.GrupoServiceLocal;
import com.fpmislata.service.ProfesorServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class ControllerProfesor extends HttpServlet {

    @EJB
    private GrupoServiceLocal grupoService;

    @EJB
    private ProfesorServiceLocal profesorService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/ListarProfesores")) {
            listarProfesores(request, response);
        }
    }

    private void listarProfesores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List listaProfesores = profesorService.listProfesores();
            ArrayList<Profesor> listaArrayProfesor = new ArrayList(listaProfesores);
            request.getSession().setAttribute("profesor", listaArrayProfesor);

            List listaGrupos = grupoService.listGrupos();
            ArrayList<Grupo> listaArrayGrupo = new ArrayList(listaGrupos);
            request.getSession().setAttribute("grupo", listaArrayGrupo);

            RequestDispatcher rd = request.getRequestDispatcher("/listarProfesoresGrupos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
