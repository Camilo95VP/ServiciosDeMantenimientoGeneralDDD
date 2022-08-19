package co.com.mantenimiento.personal.values;

import co.com.sofka.domain.generic.Identity;

public class PersonalId extends Identity {

    public PersonalId(String id){super(id);};

    public PersonalId(){}

    public static PersonalId of(String id){ return new PersonalId(id);}
}
