package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdComentario;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionDeComentario implements Command {
    private final IdPublicacion idPublicacion;
    private final IdComentario idComentario;
    private final Descripcion descripcion;

    public ModificarDescripcionDeComentario(IdPublicacion idPublicacion, IdComentario idComentario, Descripcion descripcion) {
        this.idPublicacion = idPublicacion;
        this.idComentario = idComentario;
        this.descripcion = descripcion;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public IdComentario getIdComentario() {
        return idComentario;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
