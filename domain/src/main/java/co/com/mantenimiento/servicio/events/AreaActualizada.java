package co.com.mantenimiento.servicio.events;


import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.DomainEvent;

public class AreaActualizada extends DomainEvent {

    private final ServicioId servicioId;
    private final AreaId areaId;
    private final TipoDeZona tipoDeZona;
    private final TipoDeInstalacion tipoDeInstalacion;

    public AreaActualizada(ServicioId servicioId, AreaId areaId,TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion) {
        super("co.com.mantenimiento.AreaActualizada");
        this.servicioId = servicioId;
        this.areaId = areaId;
        this.tipoDeZona = tipoDeZona;
        this.tipoDeInstalacion = tipoDeInstalacion;
    }

    public ServicioId getServicioId() {
        return servicioId;
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
