package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.ActualizarContacto;
import co.com.mantenimiento.cliente.events.ClienteCreado;
import co.com.mantenimiento.cliente.events.ContactoActualizado;
import co.com.mantenimiento.cliente.events.ContactoAgregado;
import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.ContactoId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.mantenimiento.cliente.values.Direccion;
import co.com.mantenimiento.cliente.values.WhatsApp;
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
class ActualizarContactoUseCaseTest {

    @InjectMocks
    private  ActualizarContactoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarContactoHappyPass(){

        var contactoId = ContactoId.of("089");

        //Arrange
        var command = new ActualizarContacto(
                ClienteId.of("987"),
                contactoId,
                new WhatsApp("3196736669"),
                new Direccion("Medellin"));

        when(repository.getEventsBy("987")).thenReturn(eventos(contactoId));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("987")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var contactoActualizado = (ContactoActualizado)events.get(0);
        Assertions.assertEquals("3196736669", contactoActualizado.getWhatsApp().value());
        Assertions.assertEquals("Medellin", contactoActualizado.getDireccion().value());
    }

    private List<DomainEvent> eventos(ContactoId contactoId){

        return List.of(new ClienteCreado(new DatosPersonales("Lucas", "Garcia")),

                new ContactoAgregado(contactoId,new WhatsApp("23454"), new Direccion("La ceja")),

                new ContactoAgregado(ContactoId.of("234"),new WhatsApp("3194562343"), new Direccion("Bogota")),
                new ContactoAgregado(ContactoId.of("566"),new WhatsApp("3210983423"), new Direccion("Barranquilla")),
                new ContactoAgregado(ContactoId.of("423"),new WhatsApp("3130985434"), new Direccion("Cali")),
                new ContactoAgregado(ContactoId.of("673"),new WhatsApp("3100983456"), new Direccion("Manizales"))
        );
    }

}