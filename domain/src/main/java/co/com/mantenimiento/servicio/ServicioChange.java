package co.com.mantenimiento.servicio;

import co.com.mantenimiento.cliente.events.ContactoActualizado;
import co.com.mantenimiento.servicio.entities.Area;
import co.com.mantenimiento.servicio.entities.Categoria;
import co.com.mantenimiento.servicio.events.AreaActualizada;
import co.com.mantenimiento.servicio.events.AreaAgregada;
import co.com.mantenimiento.servicio.events.CategoriaAgregada;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ServicioChange extends EventChange {

    public ServicioChange(Servicio servicio){

        apply((ServicioCreado event) -> {
            servicio.categoria = new HashSet<>();
            servicio.area = new HashSet<>();
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

        apply((AreaActualizada event) -> {
            servicio.getArea().forEach(area -> {
                System.out.println("Id=" + area.identity().value() + " " + "TipoZona=" + area.getTipoDeZona().value() + " " + "TipoInstalacion=" + area.getTipoDeInstalacion().value());
                if (area.identity().value().equals(event.getAreaId().value())) {
                    area.actualizarArea(event.getTipoDeZona(), event.getTipoDeInstalacion());
                }
            });
            var area = servicio.getArea().stream().filter(a->a.identity().value()
                    .equals(event.getAreaId().value())).findFirst().orElse(null);
            System.out.println("Id=" + area.identity().value() + " " + "TipoZona=" +area.getTipoDeZona().value() + " " + "TipoInstalacion="+area.getTipoDeInstalacion().value());
        });

    }

}
