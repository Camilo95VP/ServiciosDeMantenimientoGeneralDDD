package co.com.mantenimiento.personal.commands;

import co.com.mantenimiento.personal.values.Cobertura;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.ServicioCorrespondiente;
import co.com.mantenimiento.personal.values.TecnicoMantenimientoId;
import co.com.sofka.domain.generic.Command;

public class AgregarTecnicoMantenimiento extends Command {

    private final PersonalId personalId;
    private final TecnicoMantenimientoId tecnicoMantenimientoId;
    private final ServicioCorrespondiente servicioCorrespondiente;
    private final Cobertura cobertura;

    public AgregarTecnicoMantenimiento(PersonalId personalId, TecnicoMantenimientoId tecnicoMantenimientoId, ServicioCorrespondiente servicioCorrespondiente, Cobertura cobertura) {
        this.personalId = personalId;
        this.tecnicoMantenimientoId = tecnicoMantenimientoId;
        this.servicioCorrespondiente = servicioCorrespondiente;
        this.cobertura = cobertura;
    }

    public PersonalId getPersonalId() {
        return personalId;
    }

    public TecnicoMantenimientoId getTecnicoMantenimientoId() {
        return tecnicoMantenimientoId;
    }

    public ServicioCorrespondiente getServicioCorrespondiente() {
        return servicioCorrespondiente;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }
}
