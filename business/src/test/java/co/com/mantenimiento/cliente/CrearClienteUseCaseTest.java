package co.com.mantenimiento.cliente;

import co.com.mantenimiento.cliente.commands.CrearCliente;
import co.com.mantenimiento.cliente.events.ClienteCreado;
import co.com.mantenimiento.cliente.values.ClienteId;
import co.com.mantenimiento.cliente.values.DatosPersonales;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearClienteUseCaseTest {

    private CrearClienteUseCase useCase;

    @BeforeEach
    public void setUp(){ useCase = new CrearClienteUseCase();}

    @Test
    void crearClienteHappyPass(){

        //Arrange
        var command = new CrearCliente(ClienteId.of("333"),
                      new DatosPersonales("Juan","Castañeda"));

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var clienteCreado = (ClienteCreado)events.get(0);
        Assertions.assertEquals("Juan", clienteCreado.getDatosPersonales().getNombre());
    }

}