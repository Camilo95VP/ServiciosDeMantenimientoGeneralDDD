package co.com.mantenimiento.events;

import co.com.mantenimiento.values.Fecha;
import co.com.mantenimiento.values.GarantiaId;
import co.com.mantenimiento.values.Motivo;
import co.com.sofka.domain.generic.DomainEvent;

public class GarantiaAgregada extends DomainEvent {

    private final GarantiaId garantiaId;
    private final Motivo motivo;
    private final Fecha fecha;

    public GarantiaAgregada(GarantiaId garantiaId,Motivo motivo, Fecha fecha) {
        super("co.com.mantenimiento.GarantiaAgregada");
        this.garantiaId = garantiaId;
        this.motivo = motivo;
        this.fecha = fecha;
    }
    public GarantiaId getGarantiaId() {
        return garantiaId;
    }
    public Motivo getMotivo() {
        return motivo;
    }
    public Fecha getFecha() {
        return fecha;
    }
}
