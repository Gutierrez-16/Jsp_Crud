

<%@page import="Control.AccionesProducto"%>
<%@page import="Modelo.Producto"%>
<%@page import="Control.AccionesProveedor"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="Control.AccionesCategoria"%>
<%@page import="Modelo.Categoria"%>
<%@page import="Control.AccionesLinea"%>
<%@page import="Modelo.Linea"%>
<%@page import="Control.AccionesMarca"%>
<%@page import="Modelo.Marca"%>
<%@page import="Control.AccionesUnidadMedina"%>
<%@page import="Modelo.UnidadMedida"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla para actualizar Producto</h1>
        <form method="post" name="actualizarProducto" action="actualizarProducto">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Producto e = AccionesProducto.buscarProductooByID(id);
                %>
                <tr>
                    <td>ID</td> 
                    <td><input type="hidden" name="id2" value="<%=e.getProducto_id()%>"></td>
                </tr>
                <tr>
                    <td>nombre </td>
                    <td><input type="text" name="nombre2" size="30" value="<%=e.getNombre()%>"></td>
                </tr>
                <tr>
                    <td>descripcion  </td>
                    <td><input type="text" name="descripcion2" size="30" value="<%=e.getDescripcion()%>"></td>
                </tr>
                <tr>
                    <td>precio </td>
                    <td><input type="text" name="precio2" size="30" value="<%=e.getPrecio()%>"></td>
                </tr>
                <tr>
                    <td>cantidad_stock</td>
                    <td><input type="text" name="cantidad_stock2" size="30" value="<%=e.getCantidad_stock()%>"></td>
                </tr>
                <tr>
                    <td>fecha_registro </td>
                    <td><input type="text" name="fecha_registro2" size="30" value="<%=e.getFecha_registro()%>"></td>
                </tr>
               <tr>
                            <td>proveedor_id</td>
                            <td>
                                <select name="proveedor_id2">
                                    <% 
                                    List<Proveedor> proveedores = AccionesProveedor.getAllProveedor();
                                        for (Proveedor proveedor : proveedores) {
                                        %>
                                        <option value="<%= proveedor.getProveedor_id() %>"><%= proveedor.getNombre() %></option>
                                        <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>IDCategoria</td>
                            <td>
                                <select name="idCategoria2">
                                    <% 
                                    List<Categoria> categorias = AccionesCategoria.getAllCategoria();
                                        for (Categoria categoria : categorias) {
                                        %>
                                        <option value="<%= categoria.getIdCategoria()%>"><%= categoria.getNombreCategoria()%></option>
                                        <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>IDLinea</td>
                            <td>
                                <select name="idLinea2">
                                    <% 
                                    List<Linea> lineas = AccionesLinea.getAllLinea();
                                        for (Linea linea : lineas) {
                                        %>
                                        <option value="<%= linea.getIdLinea()%>"><%= linea.getNombreLinea()%></option>
                                        <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Marca</td>
                            <td>
                                <select name="idMarca2">
                                    <% 
                                    List<Marca> marcas = AccionesMarca.getAllMarca();
                                        for (Marca marca : marcas) {
                                        %>
                                        <option value="<%= marca.getIdMarca()%>"><%= marca.getNombreMarca()%></option>
                                        <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>UnidadMedida</td>
                            <td>
                                <select name="idUnidadMedida2">
                                    <% 
                                    List<UnidadMedida> unidadMedidas = AccionesUnidadMedina.getAllUnidadMedida();
                                        for (UnidadMedida unidadMedida : unidadMedidas) {
                                        %>
                                        <option value="<%= unidadMedida.getIdUnidadMedida()%>"><%= unidadMedida.getNombreUnidadMedida()%></option>
                                        <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                    <td>EstadoProducto </td>
                    <td><input type="text" name="estadoProducto2" size="30" value="<%=e.getEstadoProducto()%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar Producto"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
