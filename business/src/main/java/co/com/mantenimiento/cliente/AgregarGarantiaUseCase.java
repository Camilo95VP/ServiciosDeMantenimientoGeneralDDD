package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.AgregarGarantia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarGarantiaUseCase extends UseCase<RequestCommand<AgregarGarantia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGarantia> agregarGarantiaRequestCommand) {
        var command = agregarGarantiaRequestCommand.getCommand();

        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value()));

        cliente.agregarGarantia(command.getMotivo(), command.getFecha());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
