package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.AgregarVendedor;
import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.VendedorAgregado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class AgregarVendedorUseCaseTest {

    @InjectMocks
    private AgregarVendedorUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarVendedorHappyPass(){

        //Arrange
        var command = new AgregarVendedor(
                PersonalId.of("888"),
                VendedorId.of("999"),
                new TipoDeServicio("Plomeria"),
                new CantidadDeServicios(5));

        when(repository.getEventsBy("888")).thenReturn(history());

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var vendedorAgregado = (VendedorAgregado)events.get(0);
        Assertions.assertEquals("Plomeria", vendedorAgregado.getTipoDeServicio().value());
    }
    private List<DomainEvent> history(){

        var event = new PersonalCreado(new Cargo("Jardinero"));

        event.setAggregateRootId("24536543");
        return List.of(event);
    }
}