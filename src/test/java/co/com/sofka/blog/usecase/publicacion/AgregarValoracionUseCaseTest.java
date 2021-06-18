package co.com.sofka.blog.usecase.publicacion;
import co.com.sofka.blog.domain.publicacion.commands.AgregarValoracion;
import co.com.sofka.blog.domain.publicacion.events.PublicacionCreada;
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

class AgregarValoracionUseCaseTest {

    private AgregarValoracionUseCase agregarValoracionUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        agregarValoracionUseCase = new AgregarValoracionUseCase();
        repository = mock(DomainEventRepository.class);
        agregarValoracionUseCase.addRepository(repository);
    }

    @Test
    void agregarValoracionHappyPath(){
        //
        var command = new AgregarValoracion(
                IdPublicacion.of("xxx-xxx"),
                IdValoracion.of("xx-xx"),
                new Autor(
                        IdUsuario.of("id-user-1"),
                        "Sebastian Cano"
                ),
                new Puntuacion(3)
        );

        when(repository.getEventsBy(any())).thenReturn(events());
    //ACT
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        agregarValoracionUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (ValoracionAgregada)response.getDomainEvents().get(0);

        //ASSERT
        Assertions.assertEquals(3,evento.getPuntuacion().value());
        Assertions.assertEquals("xx-xx",evento.getIdValoracion().value());
        Assertions.assertEquals("id-user-1",evento.getAutor().value().idUsuario().value());
        Assertions.assertEquals("Sebastian Cano",evento.getAutor().value().nombre());
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