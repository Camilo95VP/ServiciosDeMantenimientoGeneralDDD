package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.AgregarVendedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarVendedorUseCase extends UseCase<RequestCommand<AgregarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarVendedor> agregarVendedorRequestCommand) {
        var command = agregarVendedorRequestCommand.getCommand();

        var personal = Personal.from(command.getPersonalId(),
                repository().getEventsBy(command.getPersonalId().value()));

        personal.agregarVendedor(command.getTipoDeServicio(), command.getCantidadDeServicios());

        emit().onResponse(new ResponseEvents(personal.getUncommittedChanges()));
    }
}
