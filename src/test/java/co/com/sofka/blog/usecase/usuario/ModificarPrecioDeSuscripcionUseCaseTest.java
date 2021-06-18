package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.blog.domain.usuario.commands.ModificarPrecioDeSuscripcion;
import co.com.sofka.blog.domain.usuario.events.PrecioDeSuscripcionModificado;
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

class ModificarPrecioDeSuscripcionUseCaseTest {

    private ModificarPrecioDeSuscripcionUseCase modificarPrecioDeSuscripcionUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        modificarPrecioDeSuscripcionUseCase = new ModificarPrecioDeSuscripcionUseCase();
        repository = mock(DomainEventRepository.class);
        modificarPrecioDeSuscripcionUseCase.addRepository(repository);
    }

    @Test
    void modificarPrecioDeSuscripcionHappyPath() {
        //arrange
        var command = new ModificarPrecioDeSuscripcion(
                IdUsuario.of("xxx-xxx"),
                new Precio("100000")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxxx")
                .syncExecutor(
                        modificarPrecioDeSuscripcionUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (PrecioDeSuscripcionModificado) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("100000", evento.getPrecio().value());
    }

    private List<DomainEvent> events() {
        return List.of(new UsuarioCreado(
                new Suscripcion(new IdSuscripcion("xxx-xx1"),
                        new Precio("50000"),
                        new Rango(2)),
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