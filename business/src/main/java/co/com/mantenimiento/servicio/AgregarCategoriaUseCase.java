package co.com.mantenimiento.servicio;

import co.com.mantenimiento.servicio.commands.AgregarCategoria;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarCategoriaUseCase extends UseCase<RequestCommand<AgregarCategoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCategoria> agregarCategoriaRequestCommand) {
        var commamd = agregarCategoriaRequestCommand.getCommand();

        var servicio = Servicio.from(commamd.getServicioId(),
                repository().getEventsBy(commamd.getServicioId().value()));

        servicio.agregarCategoria(commamd.getTipoCategoria(), commamd.getDescripcion());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
