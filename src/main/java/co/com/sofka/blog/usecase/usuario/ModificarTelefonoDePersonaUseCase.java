package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.ModificarTelefonoDePersona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarTelefonoDePersonaUseCase extends UseCase<RequestCommand<ModificarTelefonoDePersona>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarTelefonoDePersona> modificarTelefonoDePersonaRequestCommand) {
        var command = modificarTelefonoDePersonaRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(),retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarTelefonoDePersona(command.getTelefono());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
