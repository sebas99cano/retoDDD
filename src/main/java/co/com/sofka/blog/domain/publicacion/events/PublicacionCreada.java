package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.Comentario;
import co.com.sofka.blog.domain.publicacion.Contenido;
import co.com.sofka.blog.domain.publicacion.Valoracion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class PublicacionCreada extends DomainEvent {

    private final IdUsuario idUsuario;
    private final Contenido contenido;
    private final List<Comentario> comentarios;
    private final List<Valoracion> valoraciones;

    public PublicacionCreada(IdUsuario idUsuario, Contenido contenido, List<Comentario> comentarios, List<Valoracion> valoraciones) {
        super("blog.publicacion.publicacioncreada");
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.comentarios = comentarios;
        this.valoraciones = valoraciones;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }
}
