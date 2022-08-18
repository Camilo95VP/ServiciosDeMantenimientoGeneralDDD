package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.AgregarContactoUseCase;
import co.com.mantenimiento.commands.AgregarContacto;
import co.com.mantenimiento.events.ClienteCreado;
import co.com.mantenimiento.events.ContactoAgregado;
import co.com.mantenimiento.values.ClienteId;
import co.com.mantenimiento.values.ContactoId;
import co.com.mantenimiento.values.DatosPersonales;
import co.com.mantenimiento.values.Direccion;
import co.com.mantenimiento.values.WhatsApp;
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

class AgregarContactoUseCaseTest {
@InjectMocks
private AgregarContactoUseCase useCase;
@Mock
private DomainEventRepository repository;

@Test
void agregarContactoHappyPass(){

    //Arrange
    var command = new AgregarContacto(
            new ClienteId("111"),
            ContactoId.of("222"),
            new WhatsApp("1234234"),
            new Direccion("medellin"));

    when(repository.getEventsBy("111")).thenReturn(history());

    //Act
    var events = UseCaseHandler.getInstance()
            .setIdentifyExecutor(command.getClienteId().value())
            .syncExecutor(useCase, new RequestCommand<>(command))
            .orElseThrow()
            .getDomainEvents();

    //Asserts
    var contactoAgregado = (ContactoAgregado)events.get(0);
    Assertions.assertEquals("1234234", contactoAgregado.getWhatsApp().value());
}

private List<DomainEvent> history(){

    var event = new ClienteCreado(new DatosPersonales("Camilo", "Cast"));

    event.setAggregateRootId("13123");
    return List.of(event);
}
}