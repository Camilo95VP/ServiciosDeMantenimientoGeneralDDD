package co.com.mantenimiento.personal.values;


import co.com.sofka.domain.generic.Identity;

public class VendedorId extends Identity {
    public VendedorId(String id){super(id);};

    public VendedorId(){}

    public static VendedorId of(String id){ return new VendedorId(id);}

}
