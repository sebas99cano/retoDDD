package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdComentario;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeComentarioModificado extends DomainEvent {

    private final IdComentario idComentario;
    private final Descripcion descripcion;

    public DescripcionDeComentarioModificado(IdComentario idComentario, Descripcion descripcion) {
        super("blog.publicacion.descripciondecomentariomodificado");
        this.idComentario = idComentario;
        this.descripcion = descripcion;
    }

    public IdComentario getIdComentario() {
        return idComentario;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
