package co.com.mantenimiento.servicio.commands;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class CrearServicio extends Command {

    private final ServicioId servicioId;
    private final ClienteId clienteId;
    private final PersonalId personalId;
    private final Precio precio;

    public CrearServicio(ServicioId servicioId, ClienteId clienteId, PersonalId personalId, Precio precio) {
        this.servicioId = servicioId;
        this.clienteId = clienteId;
        this.personalId = personalId;
        this.precio = precio;
    }

    public ServicioId getServicioId() {
        return servicioId;
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
