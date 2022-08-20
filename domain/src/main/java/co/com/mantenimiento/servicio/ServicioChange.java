package co.com.mantenimiento.servicio;

import co.com.mantenimiento.servicio.entities.Area;
import co.com.mantenimiento.servicio.entities.Categoria;
import co.com.mantenimiento.servicio.events.AreaAgregada;
import co.com.mantenimiento.servicio.events.CategoriaAgregada;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.sofka.domain.generic.EventChange;

public class ServicioChange extends EventChange {

    public ServicioChange(Servicio servicio){

        apply((ServicioCreado event) -> {
            servicio.clienteId = event.getClienteId();
            servicio.personalId = event.getPersonalId();
            servicio.precio = event.getPrecio();
        });

        apply((CategoriaAgregada event) ->{
            servicio.categoria.add(new Categoria(event.getCategoriaId(), event.getTipoCategoria(), event.getDescripcion()));
        });

        apply((AreaAgregada event) -> {
            servicio.area.add(new Area(event.getAreaId(), event.getTipoDeZona(), event.getTipoDeInstalacion()));
        });

    }

}
