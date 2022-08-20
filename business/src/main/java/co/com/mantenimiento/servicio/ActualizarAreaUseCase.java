package co.com.mantenimiento.servicio;

import co.com.mantenimiento.servicio.commands.ActualizarArea;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarAreaUseCase extends UseCase<RequestCommand<ActualizarArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarArea> actualizarAreaRequestCommand) {
        var command = actualizarAreaRequestCommand.getCommand();

        var servicio = Servicio.from(command.getServicioId(),
                repository().getEventsBy(command.getServicioId().value()));

        servicio.actualizarArea(command.getServicioId(), command.getAreaId(), command.getTipoDeZona(), command.getTipoDeInstalacion());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
