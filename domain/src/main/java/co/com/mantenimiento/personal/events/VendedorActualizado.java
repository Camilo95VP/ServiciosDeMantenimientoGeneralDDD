package co.com.mantenimiento.personal.events;

import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorActualizado extends DomainEvent {

    private final PersonalId personalId;
    private final VendedorId vendedorId;
    private final TipoDeServicio tipoDeServicio;
    private final CantidadDeServicios cantidadDeServicios;

    public VendedorActualizado(PersonalId personalId, VendedorId vendedorId,TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios) {
        super("co.com.mantenimiento.VendedorActualizado");
        this.personalId = personalId;
        this.vendedorId = vendedorId;
        this.tipoDeServicio = tipoDeServicio;
        this.cantidadDeServicios = cantidadDeServicios;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public TipoDeServicio getTipoDeServicio() {
        return tipoDeServicio;
    }

    public CantidadDeServicios getCantidadDeServicios() {
        return cantidadDeServicios;
    }
}
