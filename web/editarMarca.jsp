

<%@page import="Control.AccionesMarca"%>
<%@page import="Modelo.Marca"%>
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
        <form method="post" name="actualizarMarca" action="actualizarMarca">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Marca e = AccionesMarca.buscarMarcaoByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getIdMarca()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombreMarca()%>"></td>
                </tr>
                <tr>
                    <td>estado Marca </td>
                    <td><input type="text" name="estadoMarca2" size="30" value="<%=e.getEstadoMarca()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar Marca"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
