package servlets;

import enumTipoTramite.TipoTramite;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ControladoraTurno;
import logic.ControladoraUsuario;
import logic.Turno;
import logic.Usuario;
import util.Validaciones;

@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {

    ControladoraTurno controladoraTurno = new ControladoraTurno();
    ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paginaOrigenFecha = request.getParameter("paginaOrigenFecha");
        String paginaOrigenFechaYestado = request.getParameter("paginaOrigenFechaYestado");


        
        if ("ListadoTurno.jsp".equals(paginaOrigenFecha)) {
            request.getRequestDispatcher("/ListadoTurno.jsp").forward(request, response);
        } else if ("FiltradoTurno.jsp".equals(paginaOrigenFechaYestado)) {
            request.getRequestDispatcher("/FiltradoTurno.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Validaciones
        // Nombre
        String nombre = request.getParameter("nombre");
        Validaciones.validarString(request, response, nombre);

        // Apellidos
        String apellido = request.getParameter("apellido");
        Validaciones.validarString(request, response, apellido);

        // DNI
        String dni = request.getParameter("dni");
        Validaciones.validarDni(request, response, dni);

        // Teléfono
        String telefonoStr = request.getParameter("telefono");
        int telefono =Integer.parseInt(telefonoStr);
        Validaciones.validarTelefono(request, response, telefonoStr, telefono);

        // Crear usuario
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setApellido(apellido);
        usuarioNuevo.setDni(dni);
        usuarioNuevo.setTelefono(telefono);

        // Crear turno
        String fechaStr = request.getParameter("fecha");
        String horaStr = request.getParameter("hora");
        String tipoTramiteStr = request.getParameter("tipoTramite");

        LocalDate fecha = null;
        if (fechaStr != null && !fechaStr.isEmpty()) {
            fecha = LocalDate.parse(fechaStr);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime hora = null;
        if (horaStr != null && !horaStr.isEmpty()) {
            hora = LocalTime.parse(horaStr, formatter).atDate(fecha);
        }

        TipoTramite tipoTramite = null;
        if (tipoTramiteStr != null && !tipoTramiteStr.isEmpty()) {
            tipoTramite = TipoTramite.valueOf(tipoTramiteStr);
        }

        Turno turnoNuevo = new Turno();
        turnoNuevo.setUsuario(usuarioNuevo);
        turnoNuevo.setFecha(fecha);
        turnoNuevo.setHora(hora);

        turnoNuevo.setTipoTramite(tipoTramite);
        // Establecer estado por defecto "En espera"
        turnoNuevo.setEstado(false);

        // Verificar si se está creando un turno y el estado es "En espera"
        if (request.getParameter("crearTurno") != null && turnoNuevo.isEstado()) {
            request.setAttribute("estadoEnEspera", true);
        }

        // Verificar si el usuario ya existe en la base de datos
        List<Usuario> usuarioConDni = controladoraUsuario.obtenerDniUsuario(dni);

        //Verifico si hay usuario con el mismo DNI
        if (!usuarioConDni.isEmpty()) {

            Usuario usuarioExistente = usuarioConDni.get(0);// Tomamos el primer usuario encontrado
            turnoNuevo.setUsuario(usuarioExistente);

        } else {
            //Si no existe, creamos al usuario
            controladoraUsuario.crear(usuarioNuevo);
            // Obtener el usuario recién creado con su ID asignado
            List<Usuario> usuariosCreados = controladoraUsuario.obtenerDniUsuario(dni);
            if (!usuariosCreados.isEmpty()) {

                // Tomamos el primer usuario encontrado (puedes ajustar la lógica según tus necesidades)
                Usuario usuarioCreado = usuariosCreados.get(0);
                turnoNuevo.setUsuario(usuarioCreado);
                //Después de crear el turno mandamos un mensaje de creación correcta
                request.setAttribute("mensajeTurnoCreado", "Se ha creado el turno correctamente. Muchas gracias.");
            } else {
                // En caso en el que no se pueda obtener el usuario recién creado
                request.setAttribute("errorCreacionUsuario", "Error al obtener el usuario recién creado.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }

        // Crear el turno después de verificar y obtener el usuario
        controladoraTurno.crearTurno(turnoNuevo);
        //Después de crear el turno mandamos un mensaje de creación correcta
        request.setAttribute("mensajeTurnoCreado", "Se ha creado el turno correctamente. Muchas gracias.");

        response.sendRedirect("index.jsp");
    }
}
