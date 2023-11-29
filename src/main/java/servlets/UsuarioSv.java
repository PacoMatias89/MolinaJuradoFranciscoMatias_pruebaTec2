/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ControladoraUsuario;
import logic.Usuario;

/**
 *
 * @author franc
 */
@WebServlet(name = "UsuarioSv", urlPatterns = {"/UsuarioSv"})
public class UsuarioSv extends HttpServlet {
    ControladoraUsuario controladora = new ControladoraUsuario();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioSv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        int telefono =Integer.parseInt(request.getParameter("telefono"));
        
        Usuario usuarioNuevo = new Usuario();
        
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setApellido(apellido);
        usuarioNuevo.setDni(dni);
        usuarioNuevo.setTelefono(telefono);
        controladora.crear(usuarioNuevo);
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
