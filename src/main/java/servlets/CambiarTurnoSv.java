package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ControladoraTurno;
import logic.Turno;

@WebServlet(name = "CambiarTurnoSv", urlPatterns = {"/CambiarTurnoSv"})
public class CambiarTurnoSv extends HttpServlet {

    ControladoraTurno controladoraTurno = new ControladoraTurno();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEstudiante</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEstudiante at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fechaStr = req.getParameter("fecha");
        String  estadoStr = req.getParameter("estado");
        LocalDate fecha = LocalDate.parse(fechaStr);
        boolean estado = Boolean.parseBoolean(estadoStr);

        // nos traemos la lista para obtener lo que buscamos
        List<Turno> turnoFechaEstado = controladoraTurno.buscarTurnoFechaEstado(fecha, estado);

        req.setAttribute("listadoTurno", turnoFechaEstado);
        req.getRequestDispatcher("ListadoTurno.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String turnoId = request.getParameter("turnoId");
        
        if (turnoId != null && !turnoId.isEmpty()) {
            try {
                Long idTurno = Long.valueOf(turnoId);

                // Recargar la instancia de Turno antes de cambiar el estado
                Turno turno = controladoraTurno.buscarTurnoById(idTurno);

                // Cambiar estado directamente en el servlet
                turno.setEstado(true);
                controladoraTurno.cambiarEstado(turno);

                // Redirigir a la página de listado de turnos
                // Recargamos nuevamente la lista para obtener en la vista el mensaje de "Ya atendido"
              List<Turno> listaDeTurnos = controladoraTurno.buscarTurnoFecha(turno.getFecha());
             request.setAttribute("listadoTurno", listaDeTurnos);
                request.getRequestDispatcher("/ListadoTurno.jsp").forward(request, response);
            } catch (Exception e) {
                Logger.getLogger(CambiarTurnoSv.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    // Otros métodos del servlet...
}
