<%@page import="com.fpmislata.domain.Persona"%>
<%@page import="com.fpmislata.domain.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Pedidos</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>idPedidos</th>
                <th>idPersona</th>
                <th>precio</th>
                <th></th>
                <th></th>
            </tr>

            <%
                ArrayList<Pedido> lista = (ArrayList) session.getAttribute("pedidos");
                for (Pedido pedido : lista) {

                    int id = pedido.getId();
                    Persona persona = pedido.getPersona();
                    double precio = pedido.getPrecio();
            %>                
            <tr>
                <td><%=id%></a></td>
                <td><%=persona%></td>
                <td><%=precio%></td>
                <!--
                <td><a href="ListarPedidos?id=<%=id%>">Ver Pedidos</a></td>
                <td><a href="ModificarPersona?accion=editar&id=<%=id%>">Modificar</a></td>
                <td><a href="EliminarPersona?id=<%=id%>">Eliminar</a></td>
                -->
            </tr>
            <% }%>
        </table>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
