package co.com.mantenimiento.servicio.values;

import co.com.sofka.domain.generic.Identity;

public class ServicioId extends Identity {

    public ServicioId(String id){super(id);};

    public ServicioId(){}

    public static ServicioId of(String id){ return new ServicioId(id);}
}
