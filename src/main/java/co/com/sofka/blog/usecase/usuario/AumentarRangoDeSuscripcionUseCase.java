package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.AumentarRangoDeSuscripcion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AumentarRangoDeSuscripcionUseCase extends UseCase<RequestCommand<AumentarRangoDeSuscripcion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AumentarRangoDeSuscripcion> aumentarRangoDeSuscripcionUseCaseRequestCommand) {
        var command = aumentarRangoDeSuscripcionUseCaseRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.aumentarRangoDeSuscripcion(command.getRango());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
