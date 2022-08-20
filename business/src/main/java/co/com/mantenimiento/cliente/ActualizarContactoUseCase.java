package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.ActualizarContacto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarContactoUseCase extends UseCase<RequestCommand<ActualizarContacto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarContacto> actualizarContactoRequestCommand) {
        var command = actualizarContactoRequestCommand.getCommand();

        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarContacto(command.getClienteId(),command.getContactoId(), command.getWhatsApp(), command.getDireccion());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
