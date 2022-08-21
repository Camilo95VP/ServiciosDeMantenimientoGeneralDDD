package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.ActualizarVendedor;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.events.VendedorActualizado;
import co.com.mantenimiento.personal.events.VendedorAgregado;
import co.com.mantenimiento.personal.values.CantidadDeServicios;
import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.personal.values.TipoDeServicio;
import co.com.mantenimiento.personal.values.VendedorId;
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
class ActualizarVendedorUseCaseTest {

    @InjectMocks
    private ActualizarVendedorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarVendedor(){

        var vendedorId = VendedorId.of("120");

        //Arrange
        var command = new ActualizarVendedor(
                PersonalId.of("345"),
                vendedorId,
                new TipoDeServicio("Plomeria"),
                new CantidadDeServicios(10));

        when(repository.getEventsBy("345")).thenReturn(eventos(vendedorId));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("345")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var vendedorActualizado = (VendedorActualizado)events.get(0);
        Assertions.assertEquals("Plomeria", vendedorActualizado.getTipoDeServicio().value());
        Assertions.assertEquals(10, vendedorActualizado.getCantidadDeServicios().value());
    }

    private List<DomainEvent> eventos(VendedorId vendedorId){
        return List.of(new PersonalCreado(new Cargo("Vendedor")),

                new VendedorAgregado(vendedorId,new TipoDeServicio("Jardineria"), new CantidadDeServicios(5)),

                new VendedorAgregado(VendedorId.of("567"),new TipoDeServicio("Jardineria"), new CantidadDeServicios(2)),
                new VendedorAgregado(VendedorId.of("879"),new TipoDeServicio("Jardineria"), new CantidadDeServicios(1)),
                new VendedorAgregado(VendedorId.of("675"),new TipoDeServicio("Jardineria"), new CantidadDeServicios(4))
        );
    }
}