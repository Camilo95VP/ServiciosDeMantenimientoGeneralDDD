package co.com.mantenimiento.servicio;


import co.com.mantenimiento.servicio.commands.AgregarArea;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarAreaUseCase extends UseCase<RequestCommand<AgregarArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarArea> agregarAreaRequestCommand) {
        var command = agregarAreaRequestCommand.getCommand();

        var servicio = Servicio.from(command.getServicioId(),
                repository().getEventsBy(command.getServicioId().value()));

        servicio.agregarArea(command.getTipoDeZona(), command.getTipoDeInstalacion());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
