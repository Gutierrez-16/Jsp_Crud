

<%@page import="Control.AccionesProveedor"%>
<%@page import="Modelo.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla para actualizar Proveedor</h1>
        <form method="post" name="actualizarProveedor" action="actualizarProveedor">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Proveedor e = AccionesProveedor.buscarProveedoroByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getProveedor_id()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombre()%>"></td>
                </tr>
                <tr>
                    <td>contacto  </td>
                    <td><input type="text" name="contacto2" size="30" value="<%=e.getContacto()%>"></td>
                </tr>
                <tr>
                    <td>telefono </td>
                    <td><input type="text" name="telefono2" size="30" value="<%=e.getTelefono()%>"></td>
                </tr>
                <tr>
                    <td>direccion</td>
                    <td><input type="text" name="direccion2" size="30" value="<%=e.getDireccion()%>"></td>
                </tr>
                <tr>
                    <td>ciudad </td>
                    <td><input type="text" name="ciudad2" size="30" value="<%=e.getCiudad()%>"></td>
                </tr>
                <tr>
                    <td>pais </td>
                    <td><input type="text" name="pais2" size="30" value="<%=e.getPais()%>"></td>
                </tr>
                <tr>
                    <td>estadoProveedor </td>
                    <td><input type="text" name="estadoProveedor2" size="30" value="<%=e.getEstadoProveedor()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar Proveedor"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
