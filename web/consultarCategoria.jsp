<%@page import="java.util.List"%>
<%@page import="Modelo.Categoria"%>
<%@page import="Control.AccionesCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Tabla de todo los Categoria</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>nombre</th>
                    <th>EstadoCategoria</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Categoria> lista = AccionesCategoria.getAllCategoria();
                    for(Categoria e : lista){
                    %>
                    <tr>
                        <td><%=e.getIdCategoria()%></td>
                        <td><%=e.getNombreCategoria()%></td>
                        <td><%=e.getEstadoCategoria()%></td>
                        <td><a href="editarCategoria.jsp?id=<%=e.getIdCategoria()%>">Editar</a></td>
                        <td><a href="borrarCategoria?id=<%=e.getIdCategoria()%>">Borrar</a></td>
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
