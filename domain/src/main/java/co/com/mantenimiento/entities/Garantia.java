package co.com.mantenimiento.entities;

import co.com.mantenimiento.values.Fecha;
import co.com.mantenimiento.values.GarantiaId;
import co.com.mantenimiento.values.Motivo;
import co.com.sofka.domain.generic.Entity;

public class Garantia extends Entity<GarantiaId> {

    protected Motivo motivo;
    protected Fecha fecha;

    public Garantia(GarantiaId entityId, Motivo motivo, Fecha fecha) {
        super(entityId);
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
