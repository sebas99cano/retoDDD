package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.blog.domain.usuario.commands.AumentarRangoDeSuscripcion;
import co.com.sofka.blog.domain.usuario.events.RangoDeSuscripcionAumentado;
import co.com.sofka.blog.domain.usuario.events.UsuarioCreado;
import co.com.sofka.blog.domain.usuario.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AumentarRangoDeSuscripcionUseCaseTest {

    private AumentarRangoDeSuscripcionUseCase aumentarRangoDeSuscripcionUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        aumentarRangoDeSuscripcionUseCase = new AumentarRangoDeSuscripcionUseCase();
        repository = mock(DomainEventRepository.class);
        aumentarRangoDeSuscripcionUseCase.addRepository(repository);
    }

    @Test
    void aumentarRangoDeSuscripcionHappyPath() {
        //arrange
        var command = new AumentarRangoDeSuscripcion(
                IdUsuario.of("xxx-xxx"),
                new Rango(2)
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        aumentarRangoDeSuscripcionUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (RangoDeSuscripcionAumentado) response.getDomainEvents().get(0);

        //assert

        Assertions.assertEquals(2, evento.getRango().value());
    }

    @Test
    void aumentarRangoDeSuscripcionSadPath() {
        var response = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var command = new AumentarRangoDeSuscripcion(
                    IdUsuario.of("xxx-xxx"),
                    new Rango(4)
            );
            when(repository.getEventsBy(any())).thenReturn(events());
        });

        //Assert
        Assertions.assertEquals("El rango no es valido, debe ser un valor entre 1 y 3",response.getMessage());

    }

    private List<DomainEvent> events() {
        return List.of(new UsuarioCreado(
                new Suscripcion(new IdSuscripcion("xxx-xx1"),
                        new Precio("50000"),
                        new Rango(1)),
                new Persona(new IdPersona("xxx-xx2"),
                        new FechaNacimiento(new Date(100, 5, 3)),
                        new Nombre("Sebastian cano grajales"),
                        new Correo("sebas99cano@gmail.com"),
                        new Telefono("3058935891")),
                new Cuenta(new IdCuenta("xxx-xx3"),
                        new ClaveUsuario("clave123"),
                        new NombreUsuario("sebas99cano"))
        ));
    }

}