package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.entities.Contacto;
import co.com.mantenimiento.cliente.entities.Garantia;
import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.sofka.domain.generic.AggregateEvent;

public class Cliente extends AggregateEvent<ClienteId> {

    protected DatosPersonales datosPersonales;
    protected Garantia garantia;
    protected Contacto contacto;

    public Cliente(ClienteId entityId, DatosPersonales datosPersonales, Garantia garantia, Contacto contacto) {
        super(entityId);

    }
}
