package co.com.mantenimiento.servicio;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.commands.AgregarArea;
import co.com.mantenimiento.servicio.events.AreaAgregada;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.mantenimiento.servicio.values.AreaId;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.mantenimiento.servicio.values.TipoDeInstalacion;
import co.com.mantenimiento.servicio.values.TipoDeZona;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AgregarAreaUseCaseTest {

    @InjectMocks
    private AgregarAreaUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarAreaHappyPass(){

        //Arrange
        var command = new AgregarArea(
                ServicioId.of("957"),
                AreaId.of("231"),
                new TipoDeZona("Urbana"),
                new TipoDeInstalacion("Hospital"));

        when(repository.getEventsBy("957")).thenReturn(history());

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getServicioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var areaAgregada = (AreaAgregada)events.get(0);
        Assertions.assertEquals("Urbana", areaAgregada.getTipoDeZona().value());
    }
    private List<DomainEvent> history(){

        var event = new ServicioCreado(
                ClienteId.of("345"),
                PersonalId.of("567"),
                new Precio(500000));

        event.setAggregateRootId("23455");
        return List.of(event);
    }
}