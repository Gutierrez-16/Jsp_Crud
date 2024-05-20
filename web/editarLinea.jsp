

<%@page import="Control.AccionesLinea"%>
<%@page import="Modelo.Linea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla para actualizar Linea</h1>
        <form method="post" name="actualizarLinea" action="actualizarLinea">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Linea e = AccionesLinea.buscarLineaoByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getIdLinea()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombreLinea()%>"></td>
                </tr>
                <tr>
                    <td>estado Linea </td>
                    <td><input type="text" name="estadoLinea2" size="30" value="<%=e.getEstadoLinea()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar Linea"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
