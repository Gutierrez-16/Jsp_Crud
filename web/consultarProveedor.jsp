<%@page import="java.util.List"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="Control.AccionesProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Tabla de todo los Proveedor</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>nombre</th>
                    <th> contacto</th>
                    <th>telefono</th>
                    <th> direccion</th>
                    <th>ciudad</th>
                    <th>pais</th>
                    <th>EstadoProducto</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Proveedor> lista = AccionesProveedor.getAllProveedor();
                    for(Proveedor e : lista){
                    %>
                    <tr>
                        <td><%=e.getProveedor_id()%></td>
                        <td><%=e.getNombre()%></td>
                        <td><%=e.getContacto()%></td>
                        <td><%=e.getTelefono()%></td>
                        <td><%=e.getDireccion()%></td>
                        <td><%=e.getCiudad()%></td>
                        <td><%=e.getPais()%></td>
                        <td><%=e.getEstadoProveedor()%></td>
                        <td><a href="editarProveedor.jsp?id=<%=e.getProveedor_id()%>">Editar</a></td>
                        <td><a href="borrarProveedor?id=<%=e.getProveedor_id()%>">Borrar</a></td>
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
