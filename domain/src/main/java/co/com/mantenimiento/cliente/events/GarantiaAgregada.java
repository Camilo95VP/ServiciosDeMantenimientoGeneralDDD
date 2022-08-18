package co.com.mantenimiento.cliente.events;

import co.com.mantenimiento.cliente.values.Fecha;
import co.com.mantenimiento.cliente.values.Motivo;
import co.com.sofka.domain.generic.DomainEvent;

public class GarantiaAgregada extends DomainEvent {

    private final Motivo motivo;
    private final Fecha fecha;

    public GarantiaAgregada(Motivo motivo, Fecha fecha) {
        super("co.com.mantenimiento.GarantiaAgregada");
        this.motivo = motivo;
        this.fecha = fecha;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
