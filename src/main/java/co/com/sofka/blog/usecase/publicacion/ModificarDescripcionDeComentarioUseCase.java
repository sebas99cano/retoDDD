package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.Publicacion;
import co.com.sofka.blog.domain.publicacion.commands.ModificarDescripcionDeComentario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarDescripcionDeComentarioUseCase extends UseCase<RequestCommand<ModificarDescripcionDeComentario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarDescripcionDeComentario> modificarDescripcionDeComentarioRequestCommand) {
        var command = modificarDescripcionDeComentarioRequestCommand.getCommand();
        var publicacion = Publicacion.from(command.getIdPublicacion(),retrieveEvents(command.getIdPublicacion().value()));
        publicacion.modificarDescripcionDeComentario(command.getIdComentario(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
