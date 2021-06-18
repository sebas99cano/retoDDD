package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.commands.CrearPublicacion;
import co.com.sofka.blog.domain.publicacion.events.PublicacionCreada;
import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearPublicacionUseCaseTest {

    private CrearPublicacionUseCase crearPublicacionUseCase;

    @BeforeEach
    public void setup() {
        crearPublicacionUseCase = new CrearPublicacionUseCase();
    }

    @Test
    void crearPublicacionHappyPath() {
        //arrange
        var command = new CrearPublicacion(
                IdPublicacion.of("xxx-xxx-xxx"),
                IdUsuario.of("xxx-xxx"),
                new Descripcion("Esta es la descripcion para la primer publicacion"),
                new Titulo("Primer titulo")
        );
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx-xxx")
                .syncExecutor(
                        crearPublicacionUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events = (PublicacionCreada) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("Primer titulo", events.getTitulo().value());
        Assertions.assertEquals("Esta es la descripcion para la primer publicacion", events.getDescripcion().value());
        Assertions.assertEquals("xxx-xxx", events.getIdUsuario().value());
    }

}