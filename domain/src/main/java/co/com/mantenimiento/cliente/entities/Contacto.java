package co.com.mantenimiento.cliente.entities;

import co.com.mantenimiento.cliente.values.ContactoId;
import co.com.mantenimiento.cliente.values.Direccion;
import co.com.mantenimiento.cliente.values.WhatsApp;
import co.com.sofka.domain.generic.Entity;

public class Contacto extends Entity<ContactoId> {
    protected WhatsApp whatsApp;
    protected Direccion direccion;

    public Contacto(ContactoId entityId, WhatsApp whatsApp, Direccion direccion) {
        super(entityId);
        this.whatsApp = whatsApp;
        this.direccion = direccion;
    }


    public WhatsApp getWhatsApp() {
        return whatsApp;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
