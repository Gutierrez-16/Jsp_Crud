package Servlet;

import Control.AccionesProveedor;
import Modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "guardarProveedor", urlPatterns = {"/guardarProveedor"})
public class guardarProveedor extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombre, contacto, telefono, direccion, ciudad, pais;
            
            nombre = request.getParameter("nombre");
            contacto = request.getParameter("contacto");
            telefono = request.getParameter("telefono");
            direccion = request.getParameter("direccion");
            ciudad = request.getParameter("ciudad");
            pais = request.getParameter("pais");
            
            Proveedor e = new Proveedor();
            
            e.setNombre(nombre);
            e.setContacto(contacto);
            e.setTelefono(telefono);
            e.setDireccion(direccion);
            e.setCiudad(ciudad);
            e.setPais(pais);
            
            int estatus = AccionesProveedor.registrarProveedor(e);
            
            if(estatus > 0 ){
                response.sendRedirect("registroProveedor.jsp");
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
