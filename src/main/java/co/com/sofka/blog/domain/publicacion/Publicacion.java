package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.events.*;
import co.com.sofka.blog.domain.publicacion.values.*;
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

    public Publicacion(IdPublicacion entityId, IdUsuario idUsuario,Descripcion descripcion, Titulo titulo) {
        super(entityId);
        Objects.requireNonNull(idUsuario);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(titulo);
        var idContenido = new IdContenido();
        appendChange(new PublicacionCreada(idUsuario,idContenido,descripcion,titulo)).apply();
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

    public void modificarPuntuacionDeValoracion(IdValoracion idValoracion,Puntuacion puntuacion){
        Objects.requireNonNull(idValoracion);
        Objects.requireNonNull(puntuacion);
        appendChange(new PuntuacionDeValoracionModificado(idValoracion,puntuacion)).apply();
    }

    public void modificarDescripcionDeComentario(IdComentario idComentario, Descripcion descripcion){
        Objects.requireNonNull(idComentario);
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionDeComentarioModificado(idComentario,descripcion)).apply();
    }

    public void modificarTituloDeContenido(Titulo titulo){
        Objects.requireNonNull(titulo);
        appendChange(new TituloDeContenidoModificado(titulo)).apply();
    }

    public void modificarDescripcionDeContenido(Descripcion descripcion){
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionDeContenidoModificado(descripcion)).apply();
    }

    public void agregarValoracion(IdValoracion idValoracion,Autor autor,Puntuacion puntuacion){
        Objects.requireNonNull(idValoracion);
        Objects.requireNonNull(autor);
        Objects.requireNonNull(puntuacion);
        appendChange(new ValoracionAgregada(idValoracion,autor,puntuacion)).apply();
    }

    public void agregarComentario(IdComentario idComentario,Descripcion descripcion,Autor autor){
        Objects.requireNonNull(idComentario);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(autor);
        appendChange(new ComentarioAgregado(idComentario,descripcion,autor)).apply();
    }

    public Valoracion valoracionPorId(IdValoracion idValoracion){
        return valoraciones.stream().filter(valor ->valor.identity().equals(idValoracion)).findFirst().orElseThrow();
    }

    public Comentario comentarioPorId(IdComentario idComentario){
        return comentarios.stream().filter(comentario -> comentario.identity().equals(idComentario)).findFirst().orElseThrow();
    }

    public IdUsuario idUsuario() {
        return idUsuario;
    }

    public Contenido contenido() {
        return contenido;
    }

    public List<Comentario> comentarios() {
        return comentarios;
    }

    public List<Valoracion> valoraciones() {
        return valoraciones;
    }
}
