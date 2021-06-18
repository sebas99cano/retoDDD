package co.com.sofka.blog.usecase.publicacion;

import co.com.sofka.blog.domain.publicacion.Publicacion;
import co.com.sofka.blog.domain.publicacion.commands.AgregarValoracion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarValoracionUseCase extends UseCase<RequestCommand<AgregarValoracion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarValoracion> agregarValoracionRequestCommand) {
        var command = agregarValoracionRequestCommand.getCommand();
        var publicacion = Publicacion.from(command.getIdPublicacion(),retrieveEvents(command.getIdPublicacion().value()));
        publicacion.agregarValoracion(command.getIdValoracion(), command.getAutor(), command.getPuntuacion());
        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
