package co.com.mantenimiento.personal.events;

import co.com.mantenimiento.personal.values.Cobertura;
import co.com.mantenimiento.personal.values.ServicioCorrespondiente;
import co.com.mantenimiento.personal.values.TecnicoMantenimientoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TecnicoMantenimientoAgregado extends DomainEvent {

    private final TecnicoMantenimientoId tecnicoMantenimientoId;
    private final ServicioCorrespondiente servicioCorrespondiente;
    private final Cobertura cobertura;

    public TecnicoMantenimientoAgregado(TecnicoMantenimientoId tecnicoMantenimientoId, ServicioCorrespondiente servicioCorrespondiente, Cobertura cobertura) {
        super("co.com.mantenimiento.TecnicoMantenimientoAgregado");
        this.tecnicoMantenimientoId = tecnicoMantenimientoId;
        this.servicioCorrespondiente = servicioCorrespondiente;
        this.cobertura = cobertura;
    }

    public TecnicoMantenimientoId getTecnicoMantenimientoId() {
        return tecnicoMantenimientoId;
    }

    public ServicioCorrespondiente getServicioCorrespondiente() {
        return servicioCorrespondiente;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }
}
