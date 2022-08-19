package co.com.mantenimiento.servicio.entities;

import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.Entity;

public class Area extends Entity<AreaId> {
    protected TipoDeZona tipoDeZona;
    protected TipoDeInstalacion tipoDeInstalacion;

    public Area(AreaId entityId, TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion) {
        super(entityId);
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
