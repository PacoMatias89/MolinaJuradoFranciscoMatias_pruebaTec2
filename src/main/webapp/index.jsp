<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Turnos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./styles.css">
    </head>
    <body>       
        <div class="container mt-4">
            <h2>Turno Cita Previa</h2>
            <form action="TurnoSv"  method="post"  onsubmit="return confirm('¿Estás seguro de registrar el turno?');">
                <!-- Nombre -->
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>

                    <% String errorNombre = (String) request.getAttribute("errorNombre"); %>
                    <% if (errorNombre != null) {%>
                    <span style="color: red;"><%= errorNombre%></span>
                    <% } %>
                </div>

                <!-- Apellido -->
                <div class="form-group">
                    <label for="apellido">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" required>
                    <% String errorApellido = (String) request.getAttribute("errorApellido"); %>
                    <% if (errorApellido != null) {%>
                    <span style="color: red;"><%= errorApellido%></span>
                    <% } %>
                </div>

                <!-- DNI -->
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dni" required>
                    <% String errorDni = (String) request.getAttribute("errorDni"); %>
                    <% if (errorDni != null) {%>
                    <span style="color: red;"><%= errorDni%></span>
                    <% } %>
                </div>

                <!-- Teléfono -->
                <div class="form-group">
                    <label for="telefono">Teléfono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" required>
                    <% String errorTelefono = (String) request.getAttribute("errorTelefono"); %>
                    <% if (errorTelefono != null) {%>
                    <span style="color: red;"><%= errorTelefono%></span>
                    <% } %>
                </div>

                <div>
                    <label for="fecha">Fecha:</label>
                    <input type="date" name="fecha" required> 
                </div>

                <div class="form-group">
                    <label for="tipoTramite">Tipo de Trámite:</label>
                    <select name="tipoTramite">
                        <% for (enumTipoTramite.TipoTramite tipo : enumTipoTramite.TipoTramite.values()) {%>
                        <option value="<%= tipo.name()%>"><%= tipo.getDescripcion()%></option>
                        <% }%>
                    </select>
                </div>


                <div class="form-group">
                    <label for="hora">Hora (8:00 - 14:00):</label>
                    <select name="hora" required class="form-control">
                        <% for (int hora = 8; hora < 14; hora++) { %>
                        <% for (int minuto = 0; minuto < 60; minuto += 15) { %>
                        <% String horaStr = String.format("%02d:%02d", hora, minuto);%>
                        <option value="<%= horaStr%>"><%= horaStr%></option>
                        <% } %>
                        <% }%>
                    </select>
                </div>


                <br>
                <div class="d-flex">
                    <form action="TurnoSv" method="post" class="text-center">
                        <button type="submit" class="btn btn-primary  mt-3">Registrar turno</button>
                    </form>


                    <form action="TurnoSv" method="GET" class="text-center">
                        <input type="hidden" name="paginaOrigenFecha" value="ListadoTurno.jsp">
                        <button type="submit" class="btn btn-primary mt-3 ml-3">Buscar  turno por fecha</button>
                    </form>

                    <form action="TurnoSv" method="GET" class="text-center">

                        <input type="hidden" name="paginaOrigenFechaYestado" value="FiltradoTurno.jsp">
                        <button type="submit" class="btn btn-primary mt-3 ml-3">Busca turno por fecha y estado</button>
                    </form>

                </div>


        </div>

    </form>



    <hr>
</div>
<!-- Scripts de Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>
