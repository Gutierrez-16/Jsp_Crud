package Servlet;

import Control.AccionesProducto;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "guardarProducto", urlPatterns = {"/guardarProducto"})
public class guardarProducto extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            int idLinea = Integer.parseInt(request.getParameter("idLinea"));
            int idMarca = Integer.parseInt(request.getParameter("idMarca"));
            int idUnidadMedida = Integer.parseInt(request.getParameter("idUnidadMedida"));
            int cantidad_stock = Integer.parseInt(request.getParameter("cantidad_stock"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            
            String nombre, descripcion,fecha_registro;

            nombre = request.getParameter("nombre");
            descripcion = request.getParameter("descripcion");
            precio = Double.parseDouble(request.getParameter("precio"));
            cantidad_stock = Integer.parseInt(request.getParameter("cantidad_stock"));
            fecha_registro = request.getParameter("fecha_registro");
            proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
            idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            idLinea = Integer.parseInt(request.getParameter("idLinea"));
            idMarca = Integer.parseInt(request.getParameter("idMarca"));
            idUnidadMedida = Integer.parseInt(request.getParameter("idUnidadMedida"));
            
            
            Producto e = new Producto();
 
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
            
            int estatus = AccionesProducto.registrarProducto(e);
            
            if(estatus > 0 ){
                response.sendRedirect("registroProducto.jsp");
            }else{
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
