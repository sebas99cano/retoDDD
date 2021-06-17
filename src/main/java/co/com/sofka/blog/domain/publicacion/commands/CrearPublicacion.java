package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.Comentario;
import co.com.sofka.blog.domain.publicacion.Contenido;
import co.com.sofka.blog.domain.publicacion.Valoracion;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.Command;

import java.util.List;

public class CrearPublicacion implements Command {
    private final IdPublicacion idPublicacion;
    private final IdUsuario idUsuario;
    private final Contenido contenido;
    private final List<Comentario> comentarios;
    private final List<Valoracion> valoraciones;

    public CrearPublicacion(IdPublicacion idPublicacion, IdUsuario idUsuario, Contenido contenido, List<Comentario> comentarios, List<Valoracion> valoraciones) {
        this.idPublicacion = idPublicacion;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.comentarios = comentarios;
        this.valoraciones = valoraciones;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }
}
