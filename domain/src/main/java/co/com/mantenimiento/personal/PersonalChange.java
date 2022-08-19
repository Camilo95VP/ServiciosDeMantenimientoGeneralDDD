package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.entities.TecnicoMantenimiento;
import co.com.mantenimiento.personal.entities.Vendedor;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.TecnicoMantenimientoAgregado;
import co.com.sofka.domain.generic.EventChange;
import co.com.mantenimiento.personal.events.VendedorAgregado;

public class PersonalChange extends EventChange {

    public PersonalChange(Personal personal){

        apply((PersonalCreado event) ->{
            personal.cargo = event.getCargo();
        });

        apply((TecnicoMantenimientoAgregado event) ->{
            personal.tecnicoMantenimiento.add(new TecnicoMantenimiento(event.getTecnicoMantenimientoId(), event.getServicioCorrespondiente(), event.getCobertura()));
        });

        apply((VendedorAgregado event) ->{
            personal.vendedor.add(new Vendedor(event.getVendedorId(), event.getTipoDeServicio(), event.getCantidadDeServicios()));
        });
    }
}
