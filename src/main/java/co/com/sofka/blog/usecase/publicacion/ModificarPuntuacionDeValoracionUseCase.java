package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.Publicacion;
import co.com.sofka.blog.domain.publicacion.commands.ModificarPuntuacionDeValoracion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarPuntuacionDeValoracionUseCase extends UseCase<RequestCommand<ModificarPuntuacionDeValoracion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarPuntuacionDeValoracion> modificarPuntuacionDeValoracionRequestCommand) {

        var command = modificarPuntuacionDeValoracionRequestCommand.getCommand();
        var publicacion = Publicacion.from(command.getIdPublicacion(),retrieveEvents(command.getIdPublicacion().value()));

        publicacion.modificarPuntuacionDeValoracion(command.getIdValoracion(), command.getPuntuacion());

        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
