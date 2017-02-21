<%-- 
    Document   : listarGrupos
    Created on : 21-feb-2017, 11:57:08
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Tutor"%>
<%@page import="com.fpmislata.domain.Grupo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Personas</h1>
        
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>id</th>
                    <th>curso</th>
                    <th>grupo</th>
                    <th>tutor</th>
		</tr>
                <%
                ArrayList<Grupo> lista = (ArrayList) session.getAttribute("grupos");
                for(Grupo grupo : lista){                  
                    int id = grupo.getId();
                    String curso = grupo.getCurso();
                    String grup = grupo.getGrupo();
                    String tutor = grupo.getTutor().getNombre();
                %>                
		<tr>
                    <td><%=id%></a></td>
                    <td><%=curso%></td>
                    <td><%=grup%></td>
                    <td><%=tutor%></td>
                </tr>
                <% } %>
	</table>
	<br>
	<a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
