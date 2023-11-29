
package logic;

import enumTipoTramite.TipoTramite;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import persistencia.ControladoraPersistenciaTurno;
import persistencia.TurnoJpaController;


public class ControladoraTurno {
    
    ControladoraPersistenciaTurno controladora = new ControladoraPersistenciaTurno();

    
    public void crearTurno(Turno turno){
        controladora.crearTramite(turno);
    }
    
    public List<Turno> mostrarTurnos(){
        return controladora.mostrarTurno();
    }
    
    public void cambiarEstado(Turno turno){
        turno.setEstado(true);
        controladora.modificarEstado(turno);
    }
     
    public Turno buscarTurnoById(Long id){
        return controladora.buscarTurnoId(id);
    }
    
    public List<Turno> buscarTurnoFechaEstado(LocalDate fecha, boolean estado){
        List<Turno> turnos = controladora.mostrarTurno()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha)&& turno.isEstado() == estado ).toList();
        
        return turnos;
        
    }
    
    public List<Turno> buscarTurnoFecha(LocalDate fecha) {
        List<Turno> turnoFecha = controladora.mostrarTurno()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha)).toList();
        
        return turnoFecha;
            
    }


  
    
    
}
