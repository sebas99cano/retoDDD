package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.publicacion.events.ValoracionAgregada;
import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
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

class AgregarValoracionNotificarUseCaseTest {
    private AgregarValoracionNotificarUseCase agregarValoracionNotificarUseCase;

    private ValoracionService valoracionService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        agregarValoracionNotificarUseCase = new AgregarValoracionNotificarUseCase();
        valoracionService = mock(ValoracionService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder bilder = new ServiceBuilder();
        bilder.addService(valoracionService);
        bilder.addService(senderEmailService);
        agregarValoracionNotificarUseCase.addServiceBuilder(bilder);
    }

    @Test
    void agregarValoracionNotificarHappyPath(){
        //arrange
        var event = new ValoracionAgregada(
                IdValoracion.of("xx-xx"),
                new Autor(
                        IdUsuario.of("id-user-1"),
                        "Sebastian Cano"
                ),
                new Puntuacion(3)
        );

        when(valoracionService.getCorreoPorIdUsuario(any())).thenReturn(new Correo("sebas99cano@gmail.com.co"));
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        agregarValoracionNotificarUseCase,
                        new TriggeredEvent<>(event)
                );

        //assert
        verify(valoracionService).getCorreoPorIdUsuario(any());
        verify(senderEmailService).sendEmail(any(),anyString());

    }
}