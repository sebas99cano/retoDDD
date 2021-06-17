package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class PublicacionChange extends EventChange {
    public PublicacionChange(Publicacion publicacion) {

        apply((PublicacionCreada event)->{
            publicacion.idUsuario = event.getIdUsuario();
            publicacion.contenido = event.getContenido();
            publicacion.comentarios = new ArrayList<>();
            publicacion.valoraciones = new ArrayList<>();
        });

        apply((PuntuacionDeValoracionModificado event)->{
            publicacion.valoracionPorId(event.getIdValoracion()).modificarPuntuacion(event.getPuntuacion());
        });

        apply((DescripcionDeComentarioModificado event)->{
            publicacion.comentarioPorId(event.getIdComentario()).modificarDescripcion(event.getDescripcion());
        });

        apply((TituloDeContenidoModificado event)->{
            publicacion.contenido.modificarTitulo(event.getTitulo());
        });

        apply((DescripcionDeContenidoModificado event)->{
            publicacion.contenido.modificarDescripcion(event.getDescripcion());
        });

        apply((ValoracionAgregada event)->{
            publicacion.valoraciones.add(new Valoracion(
                    event.getIdValoracion(),
                    event.getAutor(),
                    event.getPuntuacion()
            ));
        });

        apply((ComentarioAgregado event)->{
            publicacion.comentarios.add(new Comentario(
                    event.getIdComentario(),
                    event.getDescripcion(),
                    event.getAutor()
            ));
        });
    }
}
