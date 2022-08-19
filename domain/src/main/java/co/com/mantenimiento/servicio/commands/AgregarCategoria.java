package co.com.mantenimiento.servicio.commands;

import co.com.mantenimiento.servicio.values.CategoriaId;
import co.com.mantenimiento.servicio.values.Descripcion;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.mantenimiento.servicio.values.TipoCategoria;
import co.com.sofka.domain.generic.Command;

public class AgregarCategoria extends Command {

    private final ServicioId servicioId;
    private final CategoriaId categoriaId;
    private final TipoCategoria tipoCategoria;
    private final Descripcion descripcion;

    public AgregarCategoria(ServicioId servicioId, CategoriaId categoriaId, TipoCategoria tipoCategoria, Descripcion descripcion) {
        this.servicioId = servicioId;
        this.categoriaId = categoriaId;
        this.tipoCategoria = tipoCategoria;
        this.descripcion = descripcion;
    }

    public ServicioId getServicioId() {
        return servicioId;
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
