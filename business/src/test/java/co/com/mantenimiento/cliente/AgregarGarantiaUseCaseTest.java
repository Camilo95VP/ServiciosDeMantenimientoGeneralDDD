package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.AgregarGarantia;
import co.com.mantenimiento.cliente.events.ClienteCreado;
import co.com.mantenimiento.cliente.events.GarantiaAgregada;
import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.mantenimiento.cliente.values.Fecha;
import co.com.mantenimiento.cliente.values.GarantiaId;
import co.com.mantenimiento.cliente.values.Motivo;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AgregarGarantiaUseCaseTest  {
    @InjectMocks
    private AgregarGarantiaUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarGarantiaHappyPass(){

        //Arrange
        var command = new AgregarGarantia(
                new ClienteId("222"),
                GarantiaId.of("333"),
                new Motivo("Se daño la llave"),
                new Fecha(LocalDateTime.now()));

        when(repository.getEventsBy("222")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var garantiaAgregada = (GarantiaAgregada)events.get(0);
        Assertions.assertEquals("Se daño la llave", garantiaAgregada.getMotivo().value());
    }

    private List<DomainEvent> history(){
        var event = new ClienteCreado(new DatosPersonales("Juan Diego", "Gomez"));
        event.setAggregateRootId("13123");
        return List.of(event);
    }
}