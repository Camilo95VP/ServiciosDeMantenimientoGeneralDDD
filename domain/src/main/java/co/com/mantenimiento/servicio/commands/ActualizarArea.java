package co.com.mantenimiento.servicio.commands;

import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.Command;

public class ActualizarArea extends Command {

    private final AreaId areaId;
    private final TipoDeZona tipoDeZona;
    private final TipoDeInstalacion tipoDeInstalacion;

    public ActualizarArea(AreaId areaId, TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion) {
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
