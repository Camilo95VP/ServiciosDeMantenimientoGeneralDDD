package co.com.mantenimiento.cliente;

import co.com.mantenimiento.Cliente;
import co.com.mantenimiento.commands.AgregarContacto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarContactoUseCase extends UseCase<RequestCommand<AgregarContacto>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarContacto> agregarContactoRequestCommand) {
        var command = agregarContactoRequestCommand.getCommand();

        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.agregarContacto(command.getWhatsApp(), command.getDireccion());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
