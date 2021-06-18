package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.publicacion.events.ComentarioAgregado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AgregarComentarioNotificarUseCase extends UseCase<TriggeredEvent<ComentarioAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ComentarioAgregado> comentarioAgregadoTriggeredEvent) {
        var event = comentarioAgregadoTriggeredEvent.getDomainEvent();
        var comentarioService = getService(ComnetarioService.class).orElseThrow();
        var senderEmailService = getService(SenderEmailService.class).orElseThrow();

        var email = comentarioService.getCorreoPorIdUsuario(event.getAutor().value().idUsuario());
        senderEmailService.sendEmail(email,"nuevo comentario");
    }
}
