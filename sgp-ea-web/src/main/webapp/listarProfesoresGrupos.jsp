<%@page import="com.fpmislata.domain.Grupo"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Set"%>
<%@page import="com.fpmislata.domain.Profesor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Cursos Personas</h1>

        <br/>
        <br/>

        <table border="1">



            <%
                ArrayList<Profesor> listaProfesores = (ArrayList) session.getAttribute("profesor");
                for (Profesor profesor : listaProfesores) {
                    int id = profesor.getId();
                    String nombre = profesor.getNombre();
                    String apellido = profesor.getApellido();
                    Set<Grupo> listaCursos = profesor.getGrupos();

            %>                
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Grupos</th>


            </tr> 
            <tr>
                <td><%=id%></a></td>
                <td><%=nombre%></a></td>
                <td><%=apellido%></td>
            </tr>
            <tr>
                <th ></th>
                <th >Curso</th>
                <th >Grupo</th>
                <th >Tutor</th>


            </tr>

            <%for (Grupo g : listaCursos) {
                    String nombreCurso = g.getCurso();
                    String nombreGrupo = g.getGrupo();
                    String nombreTutor = g.getTutor().getNombre();

            %>
            <tr>
                <td></td>
                <td><%=nombreCurso%></td>
                <td><%=nombreGrupo%></td>
                <td><%=nombreTutor%></td>

            </tr>
            <%
                    }
                }
            %>
        </table>



        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
