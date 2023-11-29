
package logic;

import java.util.List;
import persistencia.ControladoraPersistenciaUsuario;


public class ControladoraUsuario {
    
    ControladoraPersistenciaUsuario controladora = new ControladoraPersistenciaUsuario();
    
    public void crear(Usuario usuario){
        controladora.crearUsuario(usuario);
    }
    
    public List<Usuario> mostrarUsuarios(){
        return controladora.verUsuarios();
    }
    

    
    public List<Usuario> obtenerDniUsuario(String dni){
        List<Usuario> usuarios = controladora.verUsuarios();
        List<Usuario> usuariosConDni = usuarios.stream()
                .filter(usuario -> usuario.getDni().equalsIgnoreCase(dni))
                .toList();
        
        return usuariosConDni;
    }
    
    
}
