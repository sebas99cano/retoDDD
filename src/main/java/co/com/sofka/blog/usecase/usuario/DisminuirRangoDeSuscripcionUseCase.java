package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.DisminuirRangoDeSuscripcion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class DisminuirRangoDeSuscripcionUseCase extends UseCase<RequestCommand<DisminuirRangoDeSuscripcion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<DisminuirRangoDeSuscripcion> disminuirRangoDeSuscripcionRequestCommand) {
        var command = disminuirRangoDeSuscripcionRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(),retrieveEvents(command.getIdUsuario().value()));

        usuario.disminuirRangoDeSuscripcion(command.getRango());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
