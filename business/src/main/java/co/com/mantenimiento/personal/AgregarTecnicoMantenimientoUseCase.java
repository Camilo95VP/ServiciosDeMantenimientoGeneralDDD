package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.AgregarTecnicoMantenimiento;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarTecnicoMantenimientoUseCase extends UseCase<RequestCommand<AgregarTecnicoMantenimiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarTecnicoMantenimiento> agregarTecnicoMantenimientoRequestCommand) {
        var command = agregarTecnicoMantenimientoRequestCommand.getCommand();

        var personal = Personal.from(command.getPersonalId(),
                repository().getEventsBy(command.getPersonalId().value()));

        personal.agregarTecnicoMantenimiento(command.getServicioCorrespondiente(), command.getCobertura());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
