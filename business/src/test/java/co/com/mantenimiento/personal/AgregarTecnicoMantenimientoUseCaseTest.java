package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.AgregarTecnicoMantenimiento;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.TecnicoMantenimientoAgregado;
import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.Cobertura;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.ServicioCorrespondiente;
import co.com.mantenimiento.personal.values.TecnicoMantenimientoId;
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

class AgregarTecnicoMantenimientoUseCaseTest {
    @InjectMocks
    private AgregarTecnicoMantenimientoUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarTecnicoMantenimientoHappyPass() {

        //Arrange
        var command = new AgregarTecnicoMantenimiento(
                PersonalId.of("333"),
                TecnicoMantenimientoId.of("1234"),
                new ServicioCorrespondiente("Instalar televisores"),
                new Cobertura("Oriente Antioqueño"));

        when(repository.getEventsBy("333")).thenReturn(history());

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPersonalId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var tecnicoMantenimientoAgregado = (TecnicoMantenimientoAgregado)events.get(0);
        Assertions.assertEquals("Instalar televisores", tecnicoMantenimientoAgregado.getServicioCorrespondiente().value());
    }

    private List<DomainEvent> history(){

        var event = new PersonalCreado(new Cargo("Electrico"));

        event.setAggregateRootId("134245");
        return List.of(event);
    }
}