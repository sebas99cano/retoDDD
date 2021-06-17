package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Publicacion extends AggregateEvent<IdPublicacion> {

    protected IdUsuario idUsuario;
    protected Contenido contenido;
    protected List<Comentario> comentarios;
    protected List<Valoracion> valoraciones;

    public Publicacion(IdPublicacion entityId, IdUsuario _idUsuario, Contenido _contenido, List<Comentario> _comentarios, List<Valoracion> _valoraciones) {
        super(entityId);
        var idUsuario = Objects.requireNonNull(_idUsuario);
        var contenido = Objects.requireNonNull(_contenido);
        var comentarios = Objects.requireNonNull(_comentarios);
        var valoraciones = Objects.requireNonNull(_valoraciones);
        appendChange(new PublicacionCreada(idUsuario,contenido,comentarios,valoraciones)).apply();
    }

    public Publicacion(IdPublicacion idPublicacion){
        super(idPublicacion);
        subscribe(new PublicacionChange(this));
    }

    public static Publicacion from(IdPublicacion idPublicacion, List<DomainEvent> events){
        var publicacion = new Publicacion(idPublicacion);
        events.forEach(publicacion::applyEvent);
        return publicacion;
    }

}
