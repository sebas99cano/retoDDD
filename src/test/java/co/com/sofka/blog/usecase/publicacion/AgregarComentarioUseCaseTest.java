package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.commands.AgregarComentario;
import co.com.sofka.blog.domain.publicacion.events.ComentarioAgregado;
import co.com.sofka.blog.domain.publicacion.events.PublicacionCreada;
import co.com.sofka.blog.domain.publicacion.values.*;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarComentarioUseCaseTest {
    private AgregarComentarioUseCase agregarComentarioUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        agregarComentarioUseCase = new AgregarComentarioUseCase();
        repository = mock(DomainEventRepository.class);
        agregarComentarioUseCase.addRepository(repository);
    }

    @Test
    void agregarComentarioHappyPath() {
        var command = new AgregarComentario(
                IdPublicacion.of("xxx-xxx"),
                IdComentario.of("xx-xx"),
                new Descripcion("Esta es la descripcion del comentario actualizada"),
                new Autor(
                        IdUsuario.of("id-user-1"),
                        "Sebastian Cano"
                ));
        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        agregarComentarioUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (ComentarioAgregado) response.getDomainEvents().get(0);

        Assertions.assertEquals("Esta es la descripcion del comentario actualizada", evento.getDescripcion().value());
        Assertions.assertEquals("xx-xx", evento.getIdComentario().value());
        Assertions.assertEquals("id-user-1", evento.getAutor().value().idUsuario().value());
        Assertions.assertEquals("Sebastian Cano", evento.getAutor().value().nombre());

    }

    private List<DomainEvent> events() {
        return List.of(new PublicacionCreada(
                IdUsuario.of("id-user-1"),
                IdContenido.of("id-contenido"),
                new Descripcion("Esta es la descripcion para la primer publicacion"),
                new Titulo("Primer titulo")
        ));
    }
}