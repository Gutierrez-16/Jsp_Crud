<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="Control.AccionesProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de todo los Producto</h1>
        <table border="2">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>nombre</th>
                    <th> descripcion</th>
                    <th>precio</th>
                    <th> cantidad_stock</th>
                    <th>fecha_registro</th>
                    <th>proveedor_id</th>
                    <th>Categoria</th>
                    <th>Linea</th>
                    <th>Marca</th>
                    <th>UnidadMedida</th>
                    <th>EstadoProducsto</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Producto> lista = AccionesProducto.getAllProducto();
                    for(Producto e : lista){
                    %>
                    <tr>
                        <td><%=e.getProducto_id()%></td>
                        <td><%=e.getNombre()%></td>
                        <td><%=e.getDescripcion()%></td>
                        <td><%=e.getPrecio()%></td>
                        <td><%=e.getCantidad_stock()%></td>
                        <td><%=e.getFecha_registro()%></td>
                        <td><%=e.getProveedor_id()%></td>
                        <td><%=e.getIdCategoria()%></td>
                        <td><%=e.getIdLinea()%></td>
                        <td><%=e.getIdMarca()%></td>
                        <td><%=e.getIdUnidadMedida()%></td>
                        <td><%=e.getEstadoProducto()%></td>
                        <td><a href="editarProducto.jsp?id=<%=e.getProducto_id()%>">Editar</a></td>
                        <td><a href="borrarProducto?id=<%=e.getProducto_id()%>">Borrar</a></td>
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
