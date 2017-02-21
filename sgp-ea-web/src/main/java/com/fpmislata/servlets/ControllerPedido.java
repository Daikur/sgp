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
        } else if (userPath.equals("/ListarPedidos")) {
            listarPedidos(request, response);
        }
    }

    private void listarPedidosPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idPersona = request.getParameter("id");
            int id = Integer.valueOf(idPersona);
            Persona persona = new Persona();
            persona.setId(id);
            persona = personaService.findPersonaById(persona);
            
            ArrayList<Pedido> listaArrayPedidos = new ArrayList(persona.getPedidos());
            request.getSession().setAttribute("pedidos", listaArrayPedidos);
            RequestDispatcher rd
                    = request.getRequestDispatcher("/listarPedidos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listarPedidos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //EJECUTAMOS EL METODO Y OBTENEMOS LA LISTA
            List listaPedidos = pedidoService.listPedidos();

            //Asignamos al request el atributo facturas
            ArrayList<Pedido> listaArrayPedidos = new ArrayList<>(listaPedidos);
            request.getSession().setAttribute("pedidos", listaArrayPedidos);

            //Como podemos agregar facturas necesitamos cargar las personas
            List listaPersonas = personaService.listPersonas();
            ArrayList<Persona> listaArrayPersonas = new ArrayList<>(listaPersonas);
            request.getSession().setAttribute("personas", listaArrayPersonas);

            //Pasamos al requestDispatcher la pagina a cargar 
            RequestDispatcher rd = request.getRequestDispatcher("/listarPedidos.jsp");
            //Cargamos la pagina
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
