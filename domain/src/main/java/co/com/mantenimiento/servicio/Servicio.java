package co.com.mantenimiento.servicio;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.entities.Area;
import co.com.mantenimiento.servicio.entities.Categoria;
import co.com.mantenimiento.servicio.events.AreaActualizada;
import co.com.mantenimiento.servicio.events.AreaAgregada;
import co.com.mantenimiento.servicio.events.CategoriaAgregada;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.CategoriaId;
import co.com.mantenimiento.servicio.values.Descripcion;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.mantenimiento.servicio.values.TipoCategoria;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Servicio extends AggregateEvent<ServicioId> {
    protected ServicioId servicioId;
    protected ClienteId clienteId;
    protected PersonalId personalId;

    protected Precio precio;

    protected Set<Categoria> categoria;
    protected Set<Area> area;

    public Servicio(ServicioId servicioId, ClienteId clienteId, PersonalId personalId, Precio precio) {
        super(servicioId);
        appendChange(new ServicioCreado(clienteId,personalId,precio)).apply();
        subscribe(new ServicioChange(this));
    }
    public Servicio(ServicioId servicioId){
        super(servicioId);
        subscribe(new ServicioChange(this));
    }
    public static Servicio from(ServicioId servicioId, List<DomainEvent> events){
        var servicio = new Servicio(servicioId);
        events.forEach(servicio::applyEvent);
        return servicio;
    }

    //comportamientos
    public void agregarCategoria(TipoCategoria tipoCategoria, Descripcion descripcion){
        Objects.requireNonNull(tipoCategoria);
        Objects.requireNonNull(descripcion);
        var categoriaId = new CategoriaId();
        appendChange(new CategoriaAgregada(categoriaId,tipoCategoria,descripcion)).apply();
    }
    public void agregarArea(TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion){
        Objects.requireNonNull(tipoDeZona);
        Objects.requireNonNull(tipoDeInstalacion);
        var areaId = new AreaId();
        appendChange(new AreaAgregada(areaId,tipoDeZona,tipoDeInstalacion)).apply();
    }
    public void actualizarArea(ServicioId servicioId, AreaId areaId, TipoDeZona tipoDeZona, TipoDeInstalacion tipoDeInstalacion){
        appendChange(new AreaActualizada(servicioId,areaId,tipoDeZona,tipoDeInstalacion)).apply();
    }


    public ServicioId getServicioId() {
        return servicioId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Set<Categoria> getCategoria() {
        return categoria;
    }

    public Set<Area> getArea() {
        return area;
    }
}
