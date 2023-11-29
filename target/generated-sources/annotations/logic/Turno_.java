package logic;

import enumTipoTramite.TipoTramite;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.Usuario;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-29T19:42:20")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, LocalDate> fecha;
    public static volatile SingularAttribute<Turno, Boolean> estado;
    public static volatile SingularAttribute<Turno, LocalDateTime> hora;
    public static volatile SingularAttribute<Turno, Usuario> usuario;
    public static volatile SingularAttribute<Turno, Long> id;
    public static volatile SingularAttribute<Turno, TipoTramite> tipoTramite;

}