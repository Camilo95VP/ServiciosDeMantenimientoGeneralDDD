package co.com.mantenimiento.personal.values;

import co.com.sofka.domain.generic.Identity;

public class TecnicoMantenimientoId extends Identity {

    public TecnicoMantenimientoId(){}
    public TecnicoMantenimientoId(String id){super(id);};

    public static TecnicoMantenimientoId of(String id){ return new TecnicoMantenimientoId(id);}
}
