package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PrecioDeSuscripcionModificado extends DomainEvent {

    private final Precio precio;

    public PrecioDeSuscripcionModificado(Precio precio) {
        super("blog.usuario.preciodesuscripcionmodificado");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
