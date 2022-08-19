package co.com.mantenimiento.personal.events;

import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorAgregado extends DomainEvent {

    private final VendedorId vendedorId;
    private final TipoDeServicio tipoDeServicio;
    private final CantidadDeServicios cantidadDeServicios;

    public VendedorAgregado(VendedorId vendedorId, TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios) {
        super("co.com.mantenimiento.VendedorAgregado");
        this.vendedorId = vendedorId;
        this.tipoDeServicio = tipoDeServicio;
        this.cantidadDeServicios = cantidadDeServicios;
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
