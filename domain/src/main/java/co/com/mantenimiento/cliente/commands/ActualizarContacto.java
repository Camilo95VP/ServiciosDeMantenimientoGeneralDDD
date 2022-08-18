package co.com.mantenimiento.cliente.commands;

import co.com.mantenimiento.cliente.values.ContactoId;
import co.com.mantenimiento.cliente.values.Direccion;
import co.com.mantenimiento.cliente.values.WhatsApp;
import co.com.sofka.domain.generic.Command;

public class ActualizarContacto extends Command {

    private final ContactoId contactoId;
    private final WhatsApp whatsApp;
    private final Direccion direccion;

    public ActualizarContacto(ContactoId contactoId, WhatsApp whatsApp, Direccion direccion) {
        this.contactoId = contactoId;
        this.whatsApp = whatsApp;
        this.direccion = direccion;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public WhatsApp getWhatsApp() {
        return whatsApp;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
