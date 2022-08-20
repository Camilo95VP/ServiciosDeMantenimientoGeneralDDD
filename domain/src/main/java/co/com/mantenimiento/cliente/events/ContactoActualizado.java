package co.com.mantenimiento.cliente.events;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.ContactoId;
import co.com.mantenimiento.cliente.values.Direccion;
import co.com.mantenimiento.cliente.values.WhatsApp;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoActualizado extends DomainEvent {

    private final ContactoId contactoId;
    private final ClienteId clienteId;
    private final WhatsApp whatsApp;
    private final Direccion direccion;

    public ContactoActualizado(ClienteId clienteId,ContactoId contactoId,WhatsApp whatsApp, Direccion direccion) {
        super("co.com.mantenimiento.ContactoActualizado");
        this.clienteId = clienteId;
        this.contactoId = contactoId;
        this.whatsApp = whatsApp;
        this.direccion = direccion;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public WhatsApp getWhatsApp() {
        return whatsApp;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}