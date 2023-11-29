
package enumTipoTramite;

public enum TipoTramite {
    DNI("Solicitud de DNI"),
    PASAPORTE("Renovación de Pasaporte"),
    EMPADRONAMIENTO("Empadronamiento"),
    SEGURIDAD_SOCIAL("Trámite de la Seguridad Social"),
    HACIENDA("Declaración de la Renta"),
    MATRICULA_VEHICULO("Matriculación de Vehículo"),
    LICENCIA_OBRAS("Licencia de Obras"),
    VISA("Solicitud de Visa");

    private final String descripcion;

    TipoTramite(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
