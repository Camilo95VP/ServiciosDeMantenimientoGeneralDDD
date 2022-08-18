package co.com.mantenimiento.commands;

import co.com.mantenimiento.values.ClienteId;
import co.com.mantenimiento.values.Fecha;
import co.com.mantenimiento.values.GarantiaId;
import co.com.mantenimiento.values.Motivo;
import co.com.sofka.domain.generic.Command;

public class AgregarGarantia extends Command {
    private final ClienteId clienteId;
    private final GarantiaId garantiaId;
    private final Motivo motivo;
    private final Fecha fecha;

    public AgregarGarantia(ClienteId clienteId, GarantiaId garantiaId, Motivo motivo, Fecha fecha) {
        this.clienteId = clienteId;
        this.garantiaId = garantiaId;
        this.motivo = motivo;
        this.fecha = fecha;
    }
    public ClienteId getClienteId() {
        return clienteId;
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
