package co.com.mantenimiento.personal.entities;

import co.com.mantenimiento.personal.values.Cobertura;
import co.com.mantenimiento.personal.values.ServicioCorrespondiente;
import co.com.mantenimiento.personal.values.TecnicoMantenimientoId;
import co.com.sofka.domain.generic.Entity;

public class TecnicoMantenimiento extends Entity<TecnicoMantenimientoId>{
    protected ServicioCorrespondiente servicioCorrespondiente;
    protected Cobertura cobertura;

    public TecnicoMantenimiento(TecnicoMantenimientoId entityId, ServicioCorrespondiente servicioCorrespondiente, Cobertura cobertura) {
        super(entityId);
        this.servicioCorrespondiente = servicioCorrespondiente;
        this.cobertura = cobertura;
    }

    public ServicioCorrespondiente getServicioCorrespondiente() {
        return servicioCorrespondiente;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }
}
