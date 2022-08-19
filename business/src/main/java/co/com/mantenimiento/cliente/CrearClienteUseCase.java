package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.CrearCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command = crearClienteRequestCommand.getCommand();

        var cliente = new Cliente(command.getClienteId(),command.getDatosPersonales());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
