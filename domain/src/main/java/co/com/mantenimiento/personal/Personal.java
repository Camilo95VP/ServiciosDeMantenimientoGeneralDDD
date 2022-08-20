package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.entities.TecnicoMantenimiento;
import co.com.mantenimiento.personal.entities.Vendedor;
import co.com.mantenimiento.personal.events.VendedorActualizado;
import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.TecnicoMantenimientoAgregado;
import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.Cobertura;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.ServicioCorrespondiente;
import co.com.mantenimiento.personal.values.TecnicoMantenimientoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.mantenimiento.personal.events.VendedorAgregado;

import java.util.List;
import java.util.Set;

public class Personal extends AggregateEvent<PersonalId> {

    protected PersonalId personalId;
    protected Cargo cargo;
    protected Set<TecnicoMantenimiento> tecnicoMantenimiento;
    protected Set<Vendedor> vendedor;

    public Personal(PersonalId personalId, Cargo cargo) {
        super(personalId);
        appendChange(new PersonalCreado(cargo)).apply();
        subscribe(new PersonalChange(this));
    }
    public Personal(PersonalId personalId){
        super(personalId);
        subscribe(new PersonalChange(this));
    }
    public static Personal from(PersonalId personalId, List<DomainEvent> events){
        var personal = new Personal(personalId);
        events.forEach(personal::applyEvent);
        return personal;
    }

    //comportamientos
    public void agregarTecnicoMantenimiento(ServicioCorrespondiente servicioCorrespondiente, Cobertura cobertura){
        var tecnicoMantenimientoId = new TecnicoMantenimientoId();
        appendChange(new TecnicoMantenimientoAgregado(tecnicoMantenimientoId,servicioCorrespondiente,cobertura)).apply();
    }
    public void agregarVendedor(TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios){
        var vendedorId = new VendedorId();
        appendChange(new VendedorAgregado(vendedorId,tipoDeServicio,cantidadDeServicios)).apply();
    }
    public void actualizarVendedor(PersonalId personalId, VendedorId vendedorId, TipoDeServicio tipoDeServicio, CantidadDeServicios cantidadDeServicios){
        appendChange(new VendedorActualizado(personalId,vendedorId,tipoDeServicio,cantidadDeServicios)).apply();
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Set<TecnicoMantenimiento> getTecnicoMantenimiento() {
        return tecnicoMantenimiento;
    }

    public Set<Vendedor> getVendedor() {
        return vendedor;
    }
}
