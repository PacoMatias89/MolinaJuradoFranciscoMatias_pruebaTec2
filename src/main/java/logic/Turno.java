package logic;

import enumTipoTramite.TipoTramite;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate fecha;
    
    @Enumerated(EnumType.STRING)
    private TipoTramite tipoTramite;

    private LocalDateTime hora;

    private boolean estado;

    public Turno() {
    }

   public Turno(Usuario usuario,
            LocalDate fecha,
            LocalDateTime hora,
            boolean estado,
            TipoTramite tipoTramite) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.tipoTramite = tipoTramite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuario = usuarios;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    

}
