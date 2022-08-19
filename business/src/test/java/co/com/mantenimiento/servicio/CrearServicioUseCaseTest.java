package co.com.mantenimiento.servicio;

import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.mantenimiento.servicio.commands.CrearServicio;
import co.com.mantenimiento.servicio.events.ServicioCreado;
import co.com.mantenimiento.servicio.values.Precio;
import co.com.mantenimiento.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearServicioUseCaseTest {
    private CrearServicioUseCase useCase;

    @BeforeEach
    public void setUp(){ useCase = new CrearServicioUseCase();}

    @Test
    public void crearServicioHappyPass(){

        //Arrange
        var command = new CrearServicio(
                ServicioId.of("098"),
                ClienteId.of("145"),
                PersonalId.of("538"),
                new Precio(300000));

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var servicioCreado = (ServicioCreado)events.get(0);
        Assertions.assertEquals(300000, servicioCreado.getPrecio().value());
    }

}