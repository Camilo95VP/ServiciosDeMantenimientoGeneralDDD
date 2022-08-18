package co.com.mantenimiento.entities;

import co.com.mantenimiento.values.ContactoId;
import co.com.mantenimiento.values.Direccion;
import co.com.mantenimiento.values.WhatsApp;
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
