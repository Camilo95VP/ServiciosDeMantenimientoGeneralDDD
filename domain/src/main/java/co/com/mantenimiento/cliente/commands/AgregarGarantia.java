package co.com.mantenimiento.cliente.commands;

import co.com.mantenimiento.cliente.values.Fecha;
import co.com.mantenimiento.cliente.values.GarantiaId;
import co.com.mantenimiento.cliente.values.Motivo;
import co.com.sofka.domain.generic.Command;

public class AgregarGarantia extends Command {
    private final GarantiaId garantiaId;
    private final Motivo motivo;
    private final Fecha fecha;

    public AgregarGarantia(GarantiaId garantiaId, Motivo motivo, Fecha fecha) {
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
