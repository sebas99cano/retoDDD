package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.Publicacion;
import co.com.sofka.blog.domain.publicacion.commands.AgregarComentario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarComentarioUseCase extends UseCase<RequestCommand<AgregarComentario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarComentario> agregarComentarioRequestCommand) {
        var command = agregarComentarioRequestCommand.getCommand();
        var publicacion = Publicacion.from(command.getIdPublicacion(),retrieveEvents(command.getIdPublicacion().value()));
        publicacion.agregarComentario(command.getIdComentario(), command.getDescripcion(), command.getAutor());
        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
