/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Pedido;
import com.fpmislata.domain.Persona;
import com.fpmislata.service.PedidoServiceLocal;
import com.fpmislata.service.PersonaServiceLocal;
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
 * @author alumno
 */
public class ControllerPedido extends HttpServlet {

    @EJB
    private PersonaServiceLocal personaService;

    @EJB
    private PedidoServiceLocal pedidoService;

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
        if (userPath.equals("/ListarPedidosPersona")) {
            listarPedidosPersona(request, response);
        }
    }

    private void listarPedidosPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idPersona = request.getParameter("id");
            int id = Integer.parseInt(idPersona);
            Persona persona = new Persona();
            persona.setId(id);
            Persona p = new Persona();
            p = this.personaService.findPersonaById(p);
            ArrayList<Pedido> listaArrayPedidos = new ArrayList(p.getPedidos());
            request.getSession().setAttribute("pedidos", listaArrayPedidos);
            RequestDispatcher rd
                    = request.getRequestDispatcher("/pedidosPersona.jsp");
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
