package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.ModificarNombreDePersona;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarNombreDePersonaUseCase extends UseCase<RequestCommand<ModificarNombreDePersona>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarNombreDePersona> modificarNombreDePersonaRequestCommand) {
        var command = modificarNombreDePersonaRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarNombreDePersona(command.getNombre());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
