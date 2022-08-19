package co.com.mantenimiento.servicio.values;


import co.com.sofka.domain.generic.Identity;

public class AreaId extends Identity {
    public AreaId(String id){super(id);};

    public AreaId(){}

    public static AreaId of(String id){ return new AreaId(id);}
}
