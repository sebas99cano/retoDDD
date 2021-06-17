package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.ModificarPrecioDeSuscripcion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarPrecioDeSuscripcionUseCase extends UseCase<RequestCommand<ModificarPrecioDeSuscripcion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarPrecioDeSuscripcion> modificarPrecioDeSuscripcionRequestCommand) {
        var command = modificarPrecioDeSuscripcionRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(),retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarPrecioDeSuscripcion(command.getPrecio());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
