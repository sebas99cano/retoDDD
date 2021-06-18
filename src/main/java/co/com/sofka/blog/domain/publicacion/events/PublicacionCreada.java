package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdContenido;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.DomainEvent;

public class PublicacionCreada extends DomainEvent {

    private final IdUsuario idUsuario;
    private final Descripcion descripcion;
    private final Titulo titulo;
    private final IdContenido idContenido;

    public PublicacionCreada(IdUsuario idUsuario, IdContenido idContenido, Descripcion descripcion, Titulo titulo) {
        super("blog.publicacion.publicacioncreada");
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.idContenido = idContenido;
    }

    public IdContenido getIdContenido() {
        return idContenido;
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
