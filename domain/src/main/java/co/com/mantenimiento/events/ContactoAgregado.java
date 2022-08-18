package co.com.mantenimiento.events;

import co.com.mantenimiento.values.ContactoId;
import co.com.mantenimiento.values.Direccion;
import co.com.mantenimiento.values.WhatsApp;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoAgregado extends DomainEvent {

    private final ContactoId contactoId;
    private final WhatsApp whatsApp;
    private final Direccion direccion;

    public ContactoAgregado(ContactoId contactoId, WhatsApp whatsApp, Direccion direccion) {
        super("co.com.mantenimiento.ContactoAgregado");
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
