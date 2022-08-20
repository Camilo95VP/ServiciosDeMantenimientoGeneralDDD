package co.com.mantenimiento.servicio.events;


import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaActualizada extends DomainEvent {

    private final TipoDeZona tipoDeZona;
    private final TipoDeInstalacion tipoDeInstalacion;

    public AreaActualizada(TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion) {
        super("co.com.mantenimiento.AreaActualizada");
        this.tipoDeZona = tipoDeZona;
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    public TipoDeZona getTipoDeZona() {
        return tipoDeZona;
    }

    public TipoDeInstalacion getTipoDeInstalacion() {
        return tipoDeInstalacion;
    }
}
