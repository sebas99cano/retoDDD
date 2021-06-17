package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeContenidoModificado extends DomainEvent {

    private final Descripcion descripcion;

    public DescripcionDeContenidoModificado(Descripcion descripcion) {
        super("blog.publicacion.descripciondecontenidomodificado");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
