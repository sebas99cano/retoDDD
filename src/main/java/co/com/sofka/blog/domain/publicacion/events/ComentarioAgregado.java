package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdComentario;
import co.com.sofka.domain.generic.DomainEvent;

public class ComentarioAgregado extends DomainEvent {

    private final IdComentario idComentario;
    private final Descripcion descripcion;
    private final Autor autor;

    public ComentarioAgregado(IdComentario idComentario, Descripcion descripcion, Autor autor) {
        super("blog.publicacion.comentarioagregado");
        this.idComentario = idComentario;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public IdComentario getIdComentario() {
        return idComentario;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Autor getAutor() {
        return autor;
    }
}
