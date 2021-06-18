package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.Command;


public class CrearPublicacion implements Command {
    private final IdPublicacion idPublicacion;
    private final IdUsuario idUsuario;
    private final Descripcion descripcion;
    private final Titulo titulo;


    public CrearPublicacion(IdPublicacion idPublicacion, IdUsuario idUsuario, Descripcion descripcion, Titulo titulo) {
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
