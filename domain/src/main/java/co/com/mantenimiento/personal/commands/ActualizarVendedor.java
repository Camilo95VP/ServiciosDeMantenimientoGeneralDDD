package co.com.mantenimiento.personal.commands;

import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.sofka.domain.generic.Command;

public class ActualizarVendedor extends Command {
    private final VendedorId vendedorId;
    private final TipoDeServicio tipoDeServicio;
    private final CantidadDeServicios cantidadDeServicios;

    public ActualizarVendedor(VendedorId vendedorId, TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios) {
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
