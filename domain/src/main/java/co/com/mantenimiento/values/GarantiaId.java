package co.com.mantenimiento.values;

import co.com.sofka.domain.generic.Identity;

public class GarantiaId extends Identity {

    public GarantiaId(){}
    private GarantiaId(String id){super(id);}

    public static GarantiaId of(String id){return  new GarantiaId(id);}

}
