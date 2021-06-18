package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.publicacion.events.ComentarioAgregado;
import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdComentario;
import co.com.sofka.blog.domain.usuario.values.Correo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AgregarComentarioNotificarUseCaseTest {

    private AgregarComentarioNotificarUseCase agregarComentarioNotificarUseCase;

    private ComnetarioService comnetarioService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {
        agregarComentarioNotificarUseCase = new AgregarComentarioNotificarUseCase();
        comnetarioService = mock(ComnetarioService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder bilder = new ServiceBuilder();
        bilder.addService(comnetarioService);
        bilder.addService(senderEmailService);

        agregarComentarioNotificarUseCase.addServiceBuilder(bilder);
    }

    @Test
    void agregarComentarioNotificarHappyPath() {
        var event = new ComentarioAgregado(
                IdComentario.of("xx-xx"),
                new Descripcion("nueva descripcion del comentario"),
                new Autor(
                        IdUsuario.of("id-user-1"),
                        "Sebastian Cano"
                )
        );

        when(comnetarioService.getCorreoPorIdUsuario(any())).thenReturn(new Correo("sebas99cano@gmail.com"));
        doNothing().when(senderEmailService).sendEmail(any(), anyString());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        agregarComentarioNotificarUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(comnetarioService).getCorreoPorIdUsuario(any());
        verify(senderEmailService).sendEmail(any(), anyString());
    }

}