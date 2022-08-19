package co.com.mantenimiento.personal.entities;

import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.sofka.domain.generic.Entity;

public class Vendedor extends Entity<VendedorId> {
    protected TipoDeServicio tipoDeServicio;
    protected CantidadDeServicios cantidadDeServicios;

    public Vendedor(VendedorId entityId, TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios) {
        super(entityId);
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
