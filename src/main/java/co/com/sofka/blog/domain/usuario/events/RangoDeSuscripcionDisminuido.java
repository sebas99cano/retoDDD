package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Rango;
import co.com.sofka.domain.generic.DomainEvent;

public class RangoDeSuscripcionDisminuido extends DomainEvent {

    private final Rango rango;

    public RangoDeSuscripcionDisminuido(Rango rango) {
        super("blog.usuario.rengodesuscripciondisminuido");
        this.rango = rango;
    }

    public Rango getRango() {
        return rango;
    }
}
