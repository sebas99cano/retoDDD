package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.commands.ModificarDescripcionDeComentario;
import co.com.sofka.blog.domain.publicacion.events.ComentarioAgregado;
import co.com.sofka.blog.domain.publicacion.events.DescripcionDeComentarioModificado;
import co.com.sofka.blog.domain.publicacion.events.PublicacionCreada;
import co.com.sofka.blog.domain.publicacion.events.ValoracionAgregada;
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

class ModificarDescripcionDeComentarioUseCaseTest {

    private ModificarDescripcionDeComentarioUseCase modificarDescripcionDeComentarioUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        modificarDescripcionDeComentarioUseCase = new ModificarDescripcionDeComentarioUseCase();
        repository = mock(DomainEventRepository.class);
        modificarDescripcionDeComentarioUseCase.addRepository(repository);
    }

    @Test
    void modificarDescripcionDeComentarioHappyPath() {
        //arrange
        var command = new ModificarDescripcionDeComentario(
                IdPublicacion.of("xxx-xxxx"),
                IdComentario.of("xx-xx"),
                new Descripcion("esto es una descripcion valida")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        modificarDescripcionDeComentarioUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (DescripcionDeComentarioModificado) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("esto es una descripcion valida", evento.getDescripcion().value());
    }

    private List<DomainEvent> events() {
        return List.of(new PublicacionCreada(
                IdUsuario.of("id-user-1"),
                IdContenido.of("id-contenido"),
                new Descripcion("Esta es la descripcion para la primer publicacion"),
                new Titulo("Primer titulo")
        ), new ComentarioAgregado(
                IdComentario.of("xx-xx"),
                new Descripcion("esta descripcion es diferente ok"),
                new Autor(IdUsuario.of("userid-1"), "autor numero1")
        ));
    }

}