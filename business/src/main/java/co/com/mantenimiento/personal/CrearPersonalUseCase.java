package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.CrearPersonal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPersonalUseCase extends UseCase<RequestCommand<CrearPersonal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPersonal> crearPersonalRequestCommand) {
        var command = crearPersonalRequestCommand.getCommand();

        var personal = new Personal(command.getPersonalId(), command.getCargo());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
