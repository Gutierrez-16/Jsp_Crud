package Servlet;

import Control.AccionesProducto;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class actualizarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("id2"));
            int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id2"));
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria2"));
            int idLinea = Integer.parseInt(request.getParameter("idLinea2"));
            int idMarca = Integer.parseInt(request.getParameter("idMarca2"));
            int idUnidadMedida = Integer.parseInt(request.getParameter("idUnidadMedida2"));
            int cantidad_stock = Integer.parseInt(request.getParameter("cantidad_stock2"));
            double precio = Double.parseDouble(request.getParameter("precio2"));
            
            String nombre, descripcion,fecha_registro,estadoProducto;

            nombre = request.getParameter("nombre2");
            descripcion = request.getParameter("descripcion2");
            precio = Double.parseDouble(request.getParameter("precio2"));
            cantidad_stock = Integer.parseInt(request.getParameter("cantidad_stock2"));
            fecha_registro = request.getParameter("fecha_registro2");
            proveedor_id = Integer.parseInt(request.getParameter("proveedor_id2"));
            idCategoria = Integer.parseInt(request.getParameter("idCategoria2"));
            idLinea = Integer.parseInt(request.getParameter("idLinea2"));
            idMarca = Integer.parseInt(request.getParameter("idMarca2"));
            idUnidadMedida = Integer.parseInt(request.getParameter("idUnidadMedida2"));
            estadoProducto = request.getParameter("estadoProducto2");
            
            Producto e = new Producto();

            e.setProducto_id(id);  
            e.setNombre(nombre);
            e.setDescripcion(descripcion);
            e.setPrecio(precio);
            e.setCantidad_stock(cantidad_stock);
            e.setFecha_registro(fecha_registro);
            e.setProveedor_id(proveedor_id);
            e.setIdCategoria(idCategoria);
            e.setIdLinea(idLinea);
            e.setIdMarca(idMarca);
            e.setIdUnidadMedida(idUnidadMedida);
            e.setEstadoProducto(estadoProducto);

            int estatus = AccionesProducto.actualizarProducto(e);

            if (estatus > 0) {
                response.sendRedirect("consultarProducto.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
