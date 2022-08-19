package co.com.mantenimiento.servicio.events;

import co.com.mantenimiento.servicio.values.CategoriaId;
import co.com.mantenimiento.servicio.values.Descripcion;
import co.com.mantenimiento.servicio.values.TipoCategoria;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaAgregada extends DomainEvent {

    private final CategoriaId categoriaId;
    private final TipoCategoria tipoCategoria;
    private final Descripcion descripcion;

    public CategoriaAgregada(CategoriaId categoriaId, TipoCategoria tipoCategoria, Descripcion descripcion) {
        super("co.com.mantenimiento.CategoriaAgregada");
        this.categoriaId = categoriaId;
        this.tipoCategoria = tipoCategoria;
        this.descripcion = descripcion;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
