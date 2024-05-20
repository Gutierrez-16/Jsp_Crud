

<%@page import="Control.AccionesCategoria"%>
<%@page import="Modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla para actualizar Categoria</h1>
        <form method="post" name="actualizarCategoria" action="actualizarCategoria">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Categoria e = AccionesCategoria.buscarCategoriaoByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getIdCategoria()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombreCategoria()%>"></td>
                </tr>
                <tr>
                    <td>estado Categoria </td>
                    <td><input type="text" name="estadoCategoria2" size="30" value="<%=e.getEstadoCategoria()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar Categoria"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
