package co.com.mantenimiento.personal.events;

import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.sofka.domain.generic.DomainEvent;

public class VendedorActualizado extends DomainEvent {

    private final TipoDeServicio tipoDeServicio;
    private final CantidadDeServicios cantidadDeServicios;

    public VendedorActualizado(TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios) {
        super("co.com.mantenimiento.VendedorActualizado");
        this.tipoDeServicio = tipoDeServicio;
        this.cantidadDeServicios = cantidadDeServicios;
    }

    public TipoDeServicio getTipoDeServicio() {
        return tipoDeServicio;
    }

    public CantidadDeServicios getCantidadDeServicios() {
        return cantidadDeServicios;
    }
}
