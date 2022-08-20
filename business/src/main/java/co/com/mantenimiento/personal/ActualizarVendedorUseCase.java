package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.ActualizarVendedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarVendedorUseCase extends UseCase<RequestCommand<ActualizarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarVendedor> actualizarVendedorRequestCommand) {
        var command = actualizarVendedorRequestCommand.getCommand();

        var personal = Personal.from(command.getPersonalId(),
                repository().getEventsBy(command.getPersonalId().value()));

        personal.actualizarVendedor(command.getPersonalId(), command.getVendedorId(), command.getTipoDeServicio(), command.getCantidadDeServicios());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
