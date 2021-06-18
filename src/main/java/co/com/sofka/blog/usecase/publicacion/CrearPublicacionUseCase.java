package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.Publicacion;
import co.com.sofka.blog.domain.publicacion.commands.CrearPublicacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPublicacionUseCase extends UseCase<RequestCommand<CrearPublicacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPublicacion> crearPublicacionRequestCommand) {
        var command = crearPublicacionRequestCommand.getCommand();
        var publicacion = new Publicacion(command.getIdPublicacion(),command.getIdUsuario(),command.getDescripcion(), command.getTitulo());
        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
