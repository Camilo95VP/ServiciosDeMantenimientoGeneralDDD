package co.com.mantenimiento.servicio.events;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class ServicioCreado extends DomainEvent {

    private final ClienteId clienteId;
    private final PersonalId personalId;
    private final Precio precio;

    public ServicioCreado(ClienteId clienteId, PersonalId personalId, Precio precio) {
        super("co.com.mantenimiento.ServicioCreado");
        this.clienteId = clienteId;
        this.personalId = personalId;
        this.precio = precio;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
