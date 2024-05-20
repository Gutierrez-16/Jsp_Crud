

<%@page import="Control.AccionesUnidadMedida"%>
<%@page import="Modelo.UnidadMedida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla para actualizar UnidadMedida</h1>
        <form method="post" name="actualizarUnidadMedida" action="actualizarUnidadMedida">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    UnidadMedida e = AccionesUnidadMedida.buscarUnidadMedidaoByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getIdUnidadMedida()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombreUnidadMedida()%>"></td>
                </tr>
                <tr>
                    <td>estado UnidadMedida </td>
                    <td><input type="text" name="estadoUnidadMedida2" size="30" value="<%=e.getEstadoUnidadMedida()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar UnidadMedida"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
