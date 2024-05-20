
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
<%@page import="Control.AccionesUnidadMedida"%>
<%@page import="Modelo.UnidadMedida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss.css"/>
        <script>
            function showSection(sectionId) {
                var sections = document.getElementsByClassName('section');
                for (var i = 0; i < sections.length; i++) {
                    sections[i].style.display = 'none';
                }
                document.getElementById(sectionId).style.display = 'block';
            }
        </script>
    </head>
    <body>
        <!-- Barra de navegación -->
        <div class="sidebar">
            <img src="./Image/2.jpeg" alt="Logo"> 
            <a href="javascript:void(0);" onclick="showSection('proveedores')">Proveedores</a>
            <a href="javascript:void(0);" onclick="showSection('productos')">Productos</a>
            <a href="javascript:void(0);" onclick="showSection('categorias')">Categorias</a>
            <a href="javascript:void(0);" onclick="showSection('lineas')">lineas</a>
            <a href="javascript:void(0);" onclick="showSection('Marcas')">Marcas</a>
            <a href="javascript:void(0);" onclick="showSection('UnidadMedida')">UnidadMedida</a>
        </div>

        <h1>WEB SYTEM SALES</h1>

        <div class="container section" id="proveedores" style="display: none;">
            <img src="./Image/10.jpg" alt="" >
            <div class="registroProveedor">
                <form method="post" name="registroproveedor" action="guardarProveedor">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>
                        <tr>
                            <td>contacto</td>
                            <td><input type="text" name="contacto" size="30"></td>
                        </tr>
                        <tr>
                            <td>telefono </td>
                            <td><input type="text" name="telefono" size="30" pattern="\d{9}" maxlength="9" required></td>
                        </tr>
                        <tr>
                            <td>direccion </td>
                            <td><input type="text" name="direccion" size="30"></td>
                        </tr>
                        <tr>
                            <td>ciudad </td>
                            <td><input type="text" name="ciudad" size="30"></td>
                        </tr>
                        <tr>
                            <td>pais </td>
                            <td><input type="text" name="pais" size="30"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar Proveedor"></td>
                        </tr>
                    </table>
                </form>
                <script>
                    document.querySelector('input[name="telefono"]').addEventListener('input', function (event) {
                        this.value = this.value.replace(/\D/g, '');
                    });

                    document.getElementById('phoneForm').addEventListener('submit', function (event) {
                        const telefono = document.querySelector('input[name="telefono"]').value;

                        if (telefono.length !== 9) {
                            alert('Por favor, ingrese un número de teléfono válido de 9 dígitos.');
                            event.preventDefault();
                        }
                    });
                </script>
            </div>
            <div class="containerConsulta">
                <a href="consultarProveedor.jsp">Consultar todos los proveedor</a>
            </div>
        </div>


        <div class="container section" id="productos" style="display: none;">
            <img src="./Image/4.jpeg" alt="">
            <div class="registroProducto">
                <form method="post" name="registroproducto" action="guardarProducto">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>
                        <tr>
                            <td>descripcion</td>
                            <td><input type="text" name="descripcion" size="30"></td>
                        </tr>
                        <tr>
                            <td>precio </td>
                            <td><input type="number" name="precio" step="0.01" min="0" size="30" required></td>
                        </tr>
                        <tr>
                            <td>cantidad_stock </td>
                            <td><input type="number" name="cantidad_stock" step="1" min="0" size="30" required></td>
                        </tr>
                        <tr>
                            <td>fecha_registro </td>
                            <td><input type="date" name="fecha_registro" size="30" required></td>
                        </tr>
                        <tr>
                            <td>proveedor_id</td>
                            <td>
                                <select name="proveedor_id">
                                    <%
                                        List<Proveedor> proveedores = AccionesProveedor.getAllProveedor();
                                        for (Proveedor proveedor : proveedores) {
                                    %>
                                    <option value="<%= proveedor.getProveedor_id()%>"><%= proveedor.getNombre()%></option>
                                    <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Categoria</td>
                            <td>
                                <select name="idCategoria">
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
                            <td>Linea</td>
                            <td>
                                <select name="idLinea">
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
                                <select name="idMarca">
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
                                <select name="idUnidadMedida">
                                    <%
                                        List<UnidadMedida> unidadMedidas = AccionesUnidadMedida.getAllUnidadMedida();
                                        for (UnidadMedida unidadMedida : unidadMedidas) {
                                    %>
                                    <option value="<%= unidadMedida.getIdUnidadMedida()%>"><%= unidadMedida.getNombreUnidadMedida()%></option>
                                    <% }%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar producto"></td>
                        </tr>
                    </table>
                </form>
                <script>
                    document.getElementById('productForm').addEventListener('submit', function (event) {
                        const precio = document.querySelector('input[name="precio"]').value;
                        const cantidadStock = document.querySelector('input[name="cantidad_stock"]').value;
                        const fechaRegistro = document.querySelector('input[name="fecha_registro"]').value;

                        if (isNaN(precio) || isNaN(cantidadStock)) {
                            alert('Por favor, ingrese números válidos.');
                            event.preventDefault();
                        } else if (precio <= 0) {
                            alert('El precio debe ser un número positivo.');
                            event.preventDefault();
                        } else if (!Number.isInteger(Number(cantidadStock)) || cantidadStock <= 0) {
                            alert('La cantidad en stock debe ser un número entero positivo.');
                            event.preventDefault();
                        } else if (!fechaRegistro) {
                            alert('Por favor, seleccione una fecha de registro.');
                            event.preventDefault();
                        }
                    });
                </script>
            </div>
            <div class="containerConsulta">
                <a href="consultarProducto.jsp">Consultar todos los productos</a>
            </div>
        </div>


        <div class="container section" id="categorias" style="display: none;">
            <img src="./Image/5.jpeg" alt="" >
            <div class="registroCategoria">
                <form method="post" name="registrocategoria" action="guardarCategoria">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>

                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar Categoria"></td>
                        </tr>
                    </table>
                </form>

            </div>
            <div class="containerConsulta">
                <a href="consultarCategoria.jsp">Consultar todos los categoria</a>
            </div>
        </div>


        <div class="container section" id="lineas" style="display: none;">
            <img src="./Image/6.jpeg" alt="" >
            <div class="registroLinea">
                <form method="post" name="registrolinea" action="guardarLinea">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>

                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar linea"></td>
                        </tr>
                    </table>
                </form>

            </div>
            <div class="containerConsulta">
                <a href="consultarLinea.jsp">Consultar todos los lineas</a>
            </div>
        </div>

        <div class="container section" id="Marcas" style="display: none;">
            <img src="./Image/1.jpeg" alt="" >
            <div class="registroMarca">
                <form method="post" name="registromarca" action="guardarMarca">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>

                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar Marca"></td>
                        </tr>
                    </table>
                </form>

            </div>
            <div class="containerConsulta">
                <a href="consultarMarca.jsp">Consultar todos los Marcas</a>
            </div>
        </div>


        <div class="container section" id="UnidadMedida" style="display: none;">
            <img src="Image/8.jpg" alt="" >
            <div class="registroUnidadMedida">
                <form method="post" name="registrounidadMedida" action="guardarUnidadMedida">
                    <table border="2">
                        <tr>
                            <td>nombre </td>
                            <td><input type="text" name="nombre" size="30"></td>
                        </tr>

                        <tr>
                            <td colspan="2"><input type="submit" value="Registrar UnidadMedida"></td>
                        </tr>
                    </table>
                </form>

            </div>
            <div class="containerConsulta">
                <a href="consultarUnidadMedida.jsp">Consultar todos los UnidadMedida</a>
            </div>
        </div>

        <script>
            function showTable(tableId) {
                var table = document.getElementById(tableId);
                if (table.style.display === "none") {
                    table.style.display = "table";
                } else {
                    table.style.display = "none";
                }
            }
        </script>

    </body>
</html>
