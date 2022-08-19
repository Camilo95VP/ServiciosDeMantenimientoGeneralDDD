package co.com.mantenimiento.servicio;

import co.com.mantenimiento.servicio.commands.CrearServicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearServicioUseCase extends UseCase<RequestCommand<CrearServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearServicio> crearServicioRequestCommand) {
        var command = crearServicioRequestCommand.getCommand();

        var servicio = new Servicio(command.getServicioId(), command.getClienteId(),
                command.getPersonalId(), command.getPrecio());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
