package co.com.mantenimiento.personal.events;

import co.com.mantenimiento.personal.values.Cargo;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalCreado extends DomainEvent {
    private final Cargo cargo;

    public PersonalCreado(Cargo cargo) {
        super("co.com.mantenimiento.PersonalCreado");
        this.cargo = cargo;
    }

    public Cargo getCargo() {return cargo;}
}
