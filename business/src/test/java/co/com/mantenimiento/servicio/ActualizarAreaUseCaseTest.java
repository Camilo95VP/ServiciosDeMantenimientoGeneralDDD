package co.com.mantenimiento.servicio;


import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.commands.ActualizarArea;
import co.com.mantenimiento.servicio.events.AreaActualizada;
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
class ActualizarAreaUseCaseTest {

    @InjectMocks
    private ActualizarAreaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarAreaHappyPass(){

        var areaId = AreaId.of("342");

        //Arrange
        var command = new ActualizarArea(
                ServicioId.of("675"),
                areaId,
                new TipoDeZona("Urbana"),
                new TipoDeInstalacion("Centro Comercial"));

        when(repository.getEventsBy("675")).thenReturn(eventos(areaId));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("675")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var areaActualizada = (AreaActualizada)events.get(0);
        Assertions.assertEquals("Urbana", areaActualizada.getTipoDeZona().value());
        Assertions.assertEquals("Centro Comercial", areaActualizada.getTipoDeInstalacion().value());
    }

    private List<DomainEvent> eventos(AreaId areaId){

        return List.of(new ServicioCreado(ClienteId.of("564"), PersonalId.of("567"), new Precio(2000000)),

                new AreaAgregada(areaId, new TipoDeZona("Rural"), new TipoDeInstalacion("Bodega")),

                new AreaAgregada(AreaId.of("043"), new TipoDeZona("Urbano"), new TipoDeInstalacion("Edificio")),
                new AreaAgregada(AreaId.of("123"), new TipoDeZona("Rural"), new TipoDeInstalacion("Restaurante"))

                );
        }

}