
package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validaciones {
    
    public static void validarString(HttpServletRequest request, HttpServletResponse response, String dato) throws ServletException, IOException{
         if (dato == null || dato.isEmpty() || !dato.matches("^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\\s]+$")) {
            request.setAttribute("errorNombre", "Nombre incorrecto, por favor ingrese un nombre válido. Letras (a-zA-Z)");
            // Vuelve a la página con los errores
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        }
    }
    
    public static void validarDni(HttpServletRequest request, HttpServletResponse response, String dni) throws ServletException, IOException{
           if (dni == null || dni.isEmpty() || !dni.matches("[0-9]{8}[A-Z]")) {
            request.setAttribute("errorDni", "DNI incorrecto, por favor ingrese un DNI válido. Alfanumérico (máximo 9 caracteres)");
            // Vuelve a la página con los errores
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            
        }
    }
    
    public static void validarTelefono(HttpServletRequest request, HttpServletResponse response, String telefonoStr, int telefono) throws ServletException, IOException{
        if (telefonoStr != null && !telefonoStr.isEmpty()) {
            try {
                telefono = Integer.parseInt(telefonoStr);
                if (telefono <= 0) {
                    request.setAttribute("errorTelefono", "Teléfono incorrecto, por favor ingrese un número válido.");
                    // Vuelve a la página con los errores
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorTelefono", "Teléfono incorrecto, por favor ingrese un número válido.");
                // Vuelve a la página con los errores
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("errorTelefono", "Teléfono incorrecto, por favor ingrese un número válido.");
            // Vuelve a la página con los errores
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
    }
    
}
