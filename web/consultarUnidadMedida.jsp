<%@page import="java.util.List"%>
<%@page import="Modelo.UnidadMedida"%>
<%@page import="Control.AccionesUnidadMedida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Tabla de todo los UnidadMedida</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>nombre</th>
                    <th>EstadoUnidadMedida</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<UnidadMedida> lista = AccionesUnidadMedida.getAllUnidadMedida();
                    for(UnidadMedida e : lista){
                    %>
                    <tr>
                        <td><%=e.getIdUnidadMedida()%></td>
                        <td><%=e.getNombreUnidadMedida()%></td>
                        <td><%=e.getEstadoUnidadMedida()%></td>
                        <td><a href="editarUnidadMedida.jsp?id=<%=e.getIdUnidadMedida()%>">Editar</a></td>
                        <td><a href="borrarUnidadMedida?id=<%=e.getIdUnidadMedida()%>">Borrar</a></td>
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
