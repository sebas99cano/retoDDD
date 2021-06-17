package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntuacionDeValoracionModificado extends DomainEvent {

    private final IdValoracion idValoracion;
    private final Puntuacion puntuacion;

    public PuntuacionDeValoracionModificado(IdValoracion idValoracion, Puntuacion puntuacion) {
        super("blog.publicacion.puntuaciondevaloracionmodificado");
        this.idValoracion = idValoracion;
        this.puntuacion = puntuacion;
    }

    public IdValoracion getIdValoracion() {
        return idValoracion;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
