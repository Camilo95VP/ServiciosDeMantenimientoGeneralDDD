package co.com.mantenimiento.servicio;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.commands.AgregarCategoria;
import co.com.mantenimiento.servicio.events.CategoriaAgregada;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.mantenimiento.servicio.values.CategoriaId;
import co.com.mantenimiento.servicio.values.Descripcion;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.mantenimiento.servicio.values.TipoCategoria;
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

class AgregarCategoriaUseCaseTest {

    @InjectMocks
    private AgregarCategoriaUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarCategoriaHappyPass(){

        //Arrange
        var command = new AgregarCategoria(
                ServicioId.of("104"),
                CategoriaId.of("345"),
                new TipoCategoria("Mecanica"),
                new Descripcion("Mantenimiento de vehiculos"));

        when(repository.getEventsBy("104")).thenReturn(history());

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getServicioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var categoriaAgregada = (CategoriaAgregada)events.get(0);
        Assertions.assertEquals("Mantenimiento de vehiculos", categoriaAgregada.getDescripcion().value());
    }

    private List<DomainEvent> history(){

        var event = new ServicioCreado(
                ClienteId.of("1234"),
                PersonalId.of("345"),
                new Precio(100000));

        event.setAggregateRootId("345345");
        return List.of(event);
    }
}