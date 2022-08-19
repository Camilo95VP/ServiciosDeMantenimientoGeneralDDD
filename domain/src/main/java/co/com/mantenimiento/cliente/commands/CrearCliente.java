package co.com.mantenimiento.cliente.commands;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.sofka.domain.generic.Command;

public class CrearCliente extends Command {

    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;

    public CrearCliente(ClienteId clienteId, DatosPersonales datosPersonales) {
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
