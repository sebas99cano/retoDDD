package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.commands.ModificarPuntuacionDeValoracion;
import co.com.sofka.blog.domain.publicacion.events.PublicacionCreada;
import co.com.sofka.blog.domain.publicacion.events.PuntuacionDeValoracionModificado;
import co.com.sofka.blog.domain.publicacion.events.ValoracionAgregada;
import co.com.sofka.blog.domain.publicacion.values.*;
import co.com.sofka.blog.domain.usuario.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ModificarPuntuacionDeValoracionUseCaseTest {

    private ModificarPuntuacionDeValoracionUseCase modificarPuntuacionDeValoracionUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        modificarPuntuacionDeValoracionUseCase = new ModificarPuntuacionDeValoracionUseCase();
        repository = mock(DomainEventRepository.class);
        modificarPuntuacionDeValoracionUseCase.addRepository(repository);
    }

    @Test
    void modificarPuntuacionDeValoracionHappyPath() {
        //arrange
        var command = new ModificarPuntuacionDeValoracion(
                IdPublicacion.of("xxx-xxx"),
                IdValoracion.of("xx-x2"),
                new Puntuacion(3)
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        //acts
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        modificarPuntuacionDeValoracionUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();

        var evento = (PuntuacionDeValoracionModificado) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals(3, evento.getPuntuacion().value());
    }

    private List<DomainEvent> events() {
        return List.of(new PublicacionCreada(
                IdUsuario.of("id-user-1"),
                IdContenido.of("id-contenido"),
                new Descripcion("Esta es la descripcion para la primer publicacion"),
                new Titulo("Primer titulo")
        ), new ValoracionAgregada(
                IdValoracion.of("xx-x2"),
                new Autor(IdUsuario.of("userid-1"), "autor numero1"),
                new Puntuacion(4)
        ));
    }


}