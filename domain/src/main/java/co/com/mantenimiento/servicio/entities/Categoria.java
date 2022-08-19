package co.com.mantenimiento.servicio.entities;

import co.com.mantenimiento.servicio.values.CategoriaId;
import co.com.mantenimiento.servicio.values.Descripcion;
import co.com.mantenimiento.servicio.values.TipoCategoria;
import co.com.sofka.domain.generic.Entity;

public class Categoria extends Entity<CategoriaId> {
    protected TipoCategoria tipoCategoria;
    protected Descripcion descripcion;

    public Categoria(CategoriaId entityId, TipoCategoria tipoCategoria, Descripcion descripcion) {
        super(entityId);
        this.tipoCategoria = tipoCategoria;
        this.descripcion = descripcion;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
