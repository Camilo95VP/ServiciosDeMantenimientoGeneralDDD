package co.com.mantenimiento;

import co.com.mantenimiento.entities.Contacto;
import co.com.mantenimiento.entities.Garantia;
import co.com.mantenimiento.events.ClienteCreado;
import co.com.mantenimiento.events.ContactoAgregado;
import co.com.mantenimiento.events.GarantiaAgregada;
import co.com.sofka.domain.generic.EventChange;

public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente){

        apply((ClienteCreado event) ->{
            cliente.datosPersonales = event.getDatosPersonales();
        });

        apply((ContactoAgregado event) -> {
            cliente.contacto.add(new Contacto(event.getContactoId(), event.getWhatsApp(), event.getDireccion()));
        });

        apply((GarantiaAgregada event) -> {
            cliente.garantia.add(new Garantia(event.getGarantiaId(), event.getMotivo(), event.getFecha()));
        });
    }
}
