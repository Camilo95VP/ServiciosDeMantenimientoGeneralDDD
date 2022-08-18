package co.com.mantenimiento.values;

import co.com.sofka.domain.generic.Identity;

public class ContactoId extends Identity {

    public ContactoId() {}
    private ContactoId(String id){super(id);}

    public static ContactoId of(String id){return  new ContactoId(id);}
}
