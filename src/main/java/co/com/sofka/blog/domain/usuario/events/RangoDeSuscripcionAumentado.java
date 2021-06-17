package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Rango;
import co.com.sofka.domain.generic.DomainEvent;

public class RangoDeSuscripcionAumentado extends DomainEvent {

    private final Rango rango;

    public RangoDeSuscripcionAumentado(Rango rango) {
        super("blog.usuario.rengodesuscripcionaumentado");
        this.rango = rango;
    }

    public Rango getRango() {
        return rango;
    }
}
