package co.com.mantenimiento.cliente.events;

import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteCreado extends DomainEvent {

    private final DatosPersonales datosPersonales;

    public ClienteCreado(DatosPersonales datosPersonales) {
        super("co.com.mantenimiento.ClienteCreado");
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
