package Servlet;

import Control.AccionesProveedor;
import Modelo.Proveedor;
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
public class actualizarProveedor extends HttpServlet {

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
            
            String nombre, contacto, telefono, direccion, ciudad, pais,estadoProveedor;
            
            nombre = request.getParameter("nombre2");
            contacto = request.getParameter("contacto2");
            telefono = request.getParameter("telefono2");
            direccion = request.getParameter("direccion2");
            ciudad = request.getParameter("ciudad2");
            pais = request.getParameter("pais2");
            estadoProveedor = request.getParameter("estadoProveedor2");
            
            Proveedor e = new Proveedor();
            
            e.setProveedor_id(id);
            e.setNombre(nombre);
            e.setContacto(contacto);
            e.setTelefono(telefono);
            e.setDireccion(direccion);
            e.setCiudad(ciudad);
            e.setPais(pais);
            e.setEstadoProveedor(estadoProveedor);
            
            int estatus = AccionesProveedor.actualizarProveedor(e);
            
            if(estatus > 0 ){
                response.sendRedirect("consultarProveedor.jsp");
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
