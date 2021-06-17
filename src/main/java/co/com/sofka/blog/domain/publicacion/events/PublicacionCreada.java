package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.Comentario;
import co.com.sofka.blog.domain.publicacion.Contenido;
import co.com.sofka.blog.domain.publicacion.Valoracion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class PublicacionCreada extends DomainEvent {

    private final IdUsuario idUsuario;
    private final Contenido contenido;


    public PublicacionCreada(IdUsuario idUsuario, Contenido contenido) {
        super("blog.publicacion.publicacioncreada");
        this.idUsuario = idUsuario;
        this.contenido = contenido;

    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Contenido getContenido() {
        return contenido;
    }

}
