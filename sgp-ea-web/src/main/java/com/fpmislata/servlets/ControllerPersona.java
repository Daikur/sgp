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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerPersona",
        loadOnStartup = 1,
        urlPatterns = {"/ListarPersonas",
            "/AltaPersona",
            "/EliminarPersona",
            "/ModificarPersona",
            "/ControllerPersona",
            "/ListarPedidos"})

public class ControllerPersona extends HttpServlet {
    
    @EJB
    private PersonaServiceLocal personaService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/ListarPersonas")) {
            listarPersonas(request, response);
        } else if (userPath.equals("/AltaPersona")) {
            altaPersona(request, response);
        } else if (userPath.equals("/EliminarPersona")) {
            eliminarPersona(request, response);
        } else if (userPath.equals("/ModificarPersona")) {
            modificarPersona(request, response);
        }

    }

    private void listarPersonas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List lista = personaService.listPersonas();
            ArrayList<Persona> listaArrayPersona = new ArrayList(lista);
            request.getSession().setAttribute("personas", listaArrayPersona);
            RequestDispatcher rd = request.getRequestDispatcher("/listarPersonas.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void altaPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setEmail(email);
        persona.setTelefono(telefono);
        try {
            personaService.addPersona(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Persona> lista = personaService.listPersonas();
        ArrayList<Persona> listaArrayPersona = new ArrayList(lista);
        request.setAttribute("personas", listaArrayPersona);
        request.getRequestDispatcher("/listarPersonas.jsp").forward(request, response);
    }

    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idPersona = request.getParameter("id");
        int id = Integer.parseInt(idPersona);
        Persona persona = new Persona();
        persona.setId(id);
        try {
            this.personaService.deletePersona(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List lista = personaService.listPersonas();
        ArrayList<Persona> listaArrayPersona = new ArrayList(lista);
        request.getSession().setAttribute("personas", listaArrayPersona);
        RequestDispatcher rd
                = request.getRequestDispatcher("/listarPersonas.jsp");
        rd.forward(request, response);
    }

    private void modificarPersona(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null && accion.equals("editar")) {

            String idPersona = request.getParameter("id");
            if (idPersona != null) {
                int id = Integer.valueOf(idPersona);
                Persona persona = new Persona();
                persona.setId(id);
                try {
                    persona = this.personaService.findPersonaById(persona);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("persona", persona);

                request.getRequestDispatcher("/modificarPersona.jsp").forward(request, response);
            }
        } else if (accion != null && accion.equals("modificar")) {

            String idPersona = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            Persona persona = new Persona();
            int id = Integer.valueOf(idPersona);
            persona.setId(id);
            persona.setNombre(nombre);
            persona.setEmail(email);
            persona.setTelefono(telefono);
            try {
                this.personaService.updatePersona(persona);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<Persona> lista = personaService.listPersonas();
            ArrayList<Persona> listaArrayPersona = new ArrayList(lista);
            request.getSession().setAttribute("personas", listaArrayPersona);
            request.getRequestDispatcher("/listarPersonas.jsp").forward(request,
                    response);
        }
    }

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
