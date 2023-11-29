
package persistencia;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Turno;


public class ControladoraPersistenciaTurno {
    
    TurnoJpaController turnoJpa = new TurnoJpaController();
    
    public void crearTramite(Turno turno){
        turnoJpa.create(turno);
    }
    
    public List<Turno> mostrarTurno(){
        return turnoJpa.findTurnoEntities();
    }
    
    public void modificarEstado(Turno turno){
        try {
            turnoJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Turno buscarTurnoId(Long id){
        return turnoJpa.findTurno(id);
    }
    
  
    
}
