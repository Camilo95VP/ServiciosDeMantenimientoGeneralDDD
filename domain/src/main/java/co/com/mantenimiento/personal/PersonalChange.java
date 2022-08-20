package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.entities.TecnicoMantenimiento;
import co.com.mantenimiento.personal.entities.Vendedor;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.TecnicoMantenimientoAgregado;
import co.com.mantenimiento.personal.events.VendedorActualizado;
import co.com.sofka.domain.generic.EventChange;
import co.com.mantenimiento.personal.events.VendedorAgregado;

import java.util.HashSet;

public class PersonalChange extends EventChange {

    public PersonalChange(Personal personal){

        apply((PersonalCreado event) ->{
            personal.vendedor = new HashSet<>();
            personal.tecnicoMantenimiento = new HashSet<>();
            personal.cargo = event.getCargo();
        });

        apply((TecnicoMantenimientoAgregado event) ->{
            personal.tecnicoMantenimiento.add(new TecnicoMantenimiento(event.getTecnicoMantenimientoId(), event.getServicioCorrespondiente(), event.getCobertura()));
        });

        apply((VendedorAgregado event) ->{
            personal.vendedor.add(new Vendedor(event.getVendedorId(), event.getTipoDeServicio(), event.getCantidadDeServicios()));
        });

        apply((VendedorActualizado event) -> {
            personal.getVendedor().forEach(vendedor -> {
                System.out.println("Id="+ vendedor.identity().value() + " " + "TipoServicio=" + vendedor.getTipoDeServicio().value() + " " + "CantidadServicio=" + vendedor.getCantidadDeServicios().value());
                if(vendedor.identity().value().equals(event.getVendedorId().value())){
                    vendedor.actualizarVendedor(event.getTipoDeServicio(), event.getCantidadDeServicios());
                }
            });
            var vendedor = personal.getVendedor().stream().filter(p->p.identity().value()
                    .equals(event.getVendedorId().value())).findFirst().orElse(null);
            System.out.println("Id=" + vendedor.identity().value() + " " + "TipoServicio=" +vendedor.getTipoDeServicio().value() + " " + "CantidadServicio="+vendedor.getCantidadDeServicios().value());
        });
    }
}
