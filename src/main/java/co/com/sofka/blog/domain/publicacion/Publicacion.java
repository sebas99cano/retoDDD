package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.domain.generic.AggregateEvent;

public class Publicacion extends AggregateEvent<IdPublicacion> {

    public Publicacion(IdPublicacion entityId) {
        super(entityId);
    }
}
