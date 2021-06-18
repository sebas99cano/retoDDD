package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Usuario;
import co.com.sofka.blog.domain.usuario.commands.CrearUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearUsuarioUseCase extends UseCase<RequestCommand<CrearUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearUsuario> crearUsuarioRequestCommand) {
        var commnad = crearUsuarioRequestCommand.getCommand();
        var usuario = new Usuario(commnad.getIdUsuario(), commnad.getSuscripcion(), commnad.getPersona(), commnad.getCuenta());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
