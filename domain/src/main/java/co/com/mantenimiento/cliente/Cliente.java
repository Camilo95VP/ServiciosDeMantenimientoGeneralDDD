package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.entities.Contacto;
import co.com.mantenimiento.cliente.entities.Garantia;
import co.com.mantenimiento.cliente.events.ClienteCreado;
import co.com.mantenimiento.cliente.events.ContactoAgregado;
import co.com.mantenimiento.cliente.events.GarantiaAgregada;
import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.ContactoId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.mantenimiento.cliente.values.Direccion;
import co.com.mantenimiento.cliente.values.Fecha;
import co.com.mantenimiento.cliente.values.GarantiaId;
import co.com.mantenimiento.cliente.values.Motivo;
import co.com.mantenimiento.cliente.values.WhatsApp;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteId clienteId;
    protected DatosPersonales datosPersonales;
    protected Set<Garantia> garantia;
    protected Set<Contacto> contacto;

    public Cliente(ClienteId clienteId, DatosPersonales datosPersonales) {
        super(clienteId);
        appendChange(new ClienteCreado(datosPersonales)).apply();
        subscribe(new ClienteChange(this));
    }

    public Cliente(ClienteId clienteId){
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
        var cliente= new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    //compórtamientos
    public void agregarContacto(WhatsApp whatsApp, Direccion direccion){
        var contactoId = new ContactoId();
        appendChange(new ContactoAgregado(contactoId,whatsApp,direccion));
    }

    public void agregarGarantia(Motivo motivo, Fecha fecha){
        var garantiaId = new GarantiaId();
        appendChange(new GarantiaAgregada(garantiaId,motivo,fecha));
    }

}
