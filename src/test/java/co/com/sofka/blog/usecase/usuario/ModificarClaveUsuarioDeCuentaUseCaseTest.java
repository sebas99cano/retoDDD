package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.blog.domain.usuario.commands.ModificarClaveUsuarioDeCuenta;
import co.com.sofka.blog.domain.usuario.events.ClaveUsuarioDeCuentaModificado;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ModificarClaveUsuarioDeCuentaUseCaseTest {

    private ModificarClaveUsuarioDeCuentaUseCase modificarClaveUsuarioDeCuentaUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        modificarClaveUsuarioDeCuentaUseCase = new ModificarClaveUsuarioDeCuentaUseCase();
        repository = mock(DomainEventRepository.class);
        modificarClaveUsuarioDeCuentaUseCase.addRepository(repository);
    }

    @Test
    void modificarClaveUsuarioDeCuentaHappyPath() {
        //arrange
        var command = new ModificarClaveUsuarioDeCuenta(
                IdUsuario.of("xxx-xxx"),
                new ClaveUsuario("nuevaclave")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xxx").
                syncExecutor(
                        modificarClaveUsuarioDeCuentaUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();

        var evento = (ClaveUsuarioDeCuentaModificado) response.getDomainEvents().get(0);

        //Assert
        Assertions.assertEquals("nuevaclave", evento.getClaveUsuario().value());
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