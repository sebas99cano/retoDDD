package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.ModificarClaveUsuarioDeCuenta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarClaveUsuarioDeCuentaUseCase extends UseCase<RequestCommand<ModificarClaveUsuarioDeCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarClaveUsuarioDeCuenta> modificarClaveUsuarioDeCuentaRequestCommand) {
        var command = modificarClaveUsuarioDeCuentaRequestCommand.getCommand();
        var usuario = Usuario.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarClaveUsuarioDeCuenta(command.getClaveUsuario());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }

}
