package co.com.mantenimiento.personal.commands;

import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.sofka.domain.generic.Command;

public class CrearPersonal extends Command {

    private final PersonalId personalId;
    private final Cargo cargo;

    public CrearPersonal(PersonalId personalId, Cargo cargo) {
        this.personalId = personalId;
        this.cargo = cargo;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
