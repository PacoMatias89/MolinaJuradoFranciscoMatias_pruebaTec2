/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ControladoraTurno;
import logic.Turno;

/**
 *
 * @author franc
 */
@WebServlet(name = "BuscarTurnoSv", urlPatterns = {"/BuscarTurnoSv"})
public class BuscarTurnoSv extends HttpServlet {

    ControladoraTurno controladoraTurno = new ControladoraTurno();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarTurnoSv</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarTurnoSv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Filtrado por fecha
        String fechaStr = req.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaStr);
        List<Turno> turnosFiltrados = controladoraTurno.buscarTurnoFecha(fecha);
        req.setAttribute("listadoTurno", turnosFiltrados);
        req.getRequestDispatcher("ListadoTurno.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
