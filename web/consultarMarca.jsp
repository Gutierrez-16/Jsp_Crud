<%@page import="java.util.List"%>
<%@page import="Modelo.Marca"%>
<%@page import="Control.AccionesMarca"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Tabla de todo los Marca</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>nombre</th>
                    <th>EstadoMarca</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Marca> lista = AccionesMarca.getAllMarca();
                    for(Marca e : lista){
                    %>
                    <tr>
                        <td><%=e.getIdMarca()%></td>
                        <td><%=e.getNombreMarca()%></td>
                        <td><%=e.getEstadoMarca()%></td>
                        <td><a href="editarMarca.jsp?id=<%=e.getIdMarca()%>">Editar</a></td>
                        <td><a href="borrarMarca?id=<%=e.getIdMarca()%>">Borrar</a></td>
                    </tr>
                    <%
                    }
                %>
            </tbody>
        </table>
        <br>
        <a href="index.jsp">regresar al menu principal</a>
    </body>
</html>
