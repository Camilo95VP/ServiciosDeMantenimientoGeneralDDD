package co.com.mantenimiento.personal;

import co.com.mantenimiento.personal.commands.CrearPersonal;
import co.com.mantenimiento.personal.events.PersonalCreado;
import co.com.mantenimiento.personal.values.Cargo;
import co.com.mantenimiento.personal.values.PersonalId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CrearPersonalUseCaseTest {

    private CrearPersonalUseCase useCase;

    @BeforeEach
    public void setUp(){ useCase = new CrearPersonalUseCase();}

    @Test
    public void crearPersonalHappyPass(){

        //Arrange
        var command = new CrearPersonal(PersonalId.of("444"),
                      new Cargo("Electricista"));

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var personalCreado = (PersonalCreado)events.get(0);
        Assertions.assertEquals("Electricista", personalCreado.getCargo().value());
    }

}