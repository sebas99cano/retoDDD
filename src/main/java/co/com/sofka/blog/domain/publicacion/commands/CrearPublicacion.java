package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.Contenido;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.Command;


public class CrearPublicacion implements Command {
    private final IdPublicacion idPublicacion;
    private final IdUsuario idUsuario;
    private final Contenido contenido;


    public CrearPublicacion(IdPublicacion idPublicacion, IdUsuario idUsuario, Contenido contenido) {
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Contenido getContenido() {
        return contenido;
    }

}
