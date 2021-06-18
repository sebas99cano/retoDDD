package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.publicacion.events.ValoracionAgregada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class AgregarValoracionNotificarUseCase extends UseCase<TriggeredEvent<ValoracionAgregada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ValoracionAgregada> valoracionAgregadaTriggeredEvent) {
        var event = valoracionAgregadaTriggeredEvent.getDomainEvent();
        var valoracionService = getService(ValoracionService.class).orElseThrow();//opcional porque puede que el servicio no este implementado
        var senderEmailService = getService(SenderEmailService.class).orElseThrow();

        var email = valoracionService.getCorreoPorIdUsuario(event.getAutor().value().idUsuario());
        senderEmailService.sendEmail(email,"valoracion agregada");
    }
}

