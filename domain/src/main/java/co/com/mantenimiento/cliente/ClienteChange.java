package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.entities.Contacto;
import co.com.mantenimiento.cliente.entities.Garantia;
import co.com.mantenimiento.cliente.events.ClienteCreado;
import co.com.mantenimiento.cliente.events.ContactoActualizado;
import co.com.mantenimiento.cliente.events.ContactoAgregado;
import co.com.mantenimiento.cliente.events.GarantiaAgregada;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente){

        apply((ClienteCreado event) ->{
            cliente.contacto = new HashSet<>();
            cliente.garantia = new HashSet<>();
            cliente.datosPersonales = event.getDatosPersonales();
        });

        apply((ContactoAgregado event) -> {
            cliente.contacto.add(new Contacto(event.getContactoId(), event.getWhatsApp(), event.getDireccion()));
        });

        apply((GarantiaAgregada event) -> {
            cliente.garantia.add(new Garantia(event.getGarantiaId(), event.getMotivo(), event.getFecha()));
        });

        apply((ContactoActualizado event) -> {
            cliente.getContacto().forEach(contacto -> {
                System.out.println("Id=" + contacto.identity().value() + " " + "WhatsApp=" + contacto.getWhatsApp().value() + " " + "Direccion=" + contacto.getDireccion().value());
                if (contacto.identity().value().equals(event.getContactoId().value())) {
                    contacto.actualizarContacto(event.getWhatsApp(), event.getDireccion());
                }
            });
            var contacto = cliente.getContacto().stream().filter(c->c.identity().value()
                                    .equals(event.getContactoId().value())).findFirst().orElse(null);
            System.out.println("Id=" + contacto.identity().value() + " " + "WhatsApp=" +contacto.getWhatsApp().value() + " " + "Direccion actualizada="+contacto.getDireccion().value());
        });
    }
}
