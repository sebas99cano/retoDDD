package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ValoracionAgregada extends DomainEvent {

    private final IdValoracion idValoracion;
    private final Autor autor;
    private final Puntuacion puntuacion;

    public ValoracionAgregada(IdValoracion idValoracion, Autor autor, Puntuacion puntuacion) {
        super("blog.publicacion.valoracioncreada");
        this.idValoracion = idValoracion;
        this.autor = autor;
        this.puntuacion = puntuacion;
    }

    public IdValoracion getIdValoracion() {
        return idValoracion;
    }

    public Autor getAutor() {
        return autor;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
