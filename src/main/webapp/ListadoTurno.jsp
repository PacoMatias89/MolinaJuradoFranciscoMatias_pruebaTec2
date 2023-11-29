<%@page import="logic.Turno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Listado de Turnos</title>
    </head>
    <body>
        <div class="container">
            <h3>Buscar turno por fecha</h3>

            <form action="BuscarTurnoSv" method="GET" class="text-center">
                <div class="row justify-content-center align-items-baseline">
                    <div class="col-md-6">
                        <label for="fecha">Fecha:</label>
                        <input type="date" name="fecha" required class="form-control">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary mt-3">Buscar</button>
            </form>

            <!-- Mostrar turnos registrados -->
            <% if (request.getAttribute("listadoTurno") != null && !((List<Turno>) request.getAttribute("listadoTurno")).isEmpty()) { %>
            <!-- Tu tabla de resultados de búsqueda -->
            <table class="table ">
                <thead>
                    <tr>
                        <th>Número</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>DNI</th>
                        <th>Fecha</th>
                        <th>Trámite</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Turno turno : (List<Turno>) request.getAttribute("listadoTurno")) {%>
                    <tr>
                        <td><%= turno.getId()%></td>
                        <td><%= turno.getUsuario().getNombre()%></td>
                        <td><%= turno.getUsuario().getApellido()%></td>
                        <td><%= turno.getUsuario().getDni()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= (turno.getTipoTramite() != null) ? turno.getTipoTramite().getDescripcion() : ""%></td>
                        <td><%= (turno.isEstado()) ? "Ya atendido" : "En espera"%></td>
                        <td>
                            <!-- Formulario para cambiar el estado del turno -->
                            <form action="CambiarTurnoSv" method="POST">
                                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                                <button type="submit">Cambiar Estado</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% } else { %>
            <% if (request.getAttribute("error") != null) {%>
            <p style="color: red;"><%= request.getAttribute("error")%></p>
            <% } else { %>
            <p>No se encontraron turnos.</p>
            <% } %>
           
          
            <% }%>
             <!-- Enlace para volver hacia atrás -->
              <form action="TurnoSv" method="GET">
                <a href="javascript:history.back()" class="btn btn-secondary mt-3">Volver Atrás</a>
            </form>
        </div>
    </body>
</html>
