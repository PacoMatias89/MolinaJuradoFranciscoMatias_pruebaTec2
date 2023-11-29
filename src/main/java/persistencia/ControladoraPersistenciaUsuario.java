
package persistencia;

import java.util.List;
import logic.Usuario;

public class ControladoraPersistenciaUsuario {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
    public void crearUsuario(Usuario usuario){
        
        usuarioJpa.create(usuario);
        
    }
    
    public List<Usuario> verUsuarios(){
        return usuarioJpa.findUsuarioEntities();
    }
    
    public Usuario obtenerById (Long id){
         return usuarioJpa.findUsuario(id);
    }
    
    
}
