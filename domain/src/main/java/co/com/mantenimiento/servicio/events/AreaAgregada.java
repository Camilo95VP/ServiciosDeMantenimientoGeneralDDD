package co.com.mantenimiento.servicio.events;

import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaAgregada extends DomainEvent {

    private final AreaId areaId;
    private final TipoDeZona tipoDeZona;
    private final TipoDeInstalacion tipoDeInstalacion;

    public AreaAgregada(AreaId areaId, TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion) {
        super("co.com.mantenimiento.AreaAgregada");
        this.areaId = areaId;
        this.tipoDeZona = tipoDeZona;
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    public AreaId getAreaId() {
        return areaId;
    }

    public TipoDeZona getTipoDeZona() {
        return tipoDeZona;
    }

    public TipoDeInstalacion getTipoDeInstalacion() {
        return tipoDeInstalacion;
    }
}
