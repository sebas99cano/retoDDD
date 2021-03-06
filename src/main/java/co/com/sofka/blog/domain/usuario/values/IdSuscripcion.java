package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.domain.generic.Identity;

public class IdSuscripcion extends Identity {

    public IdSuscripcion(String uuid) {
        super(uuid);
    }

    public IdSuscripcion() {
    }

    public static IdPublicacion of(String id){
        return new IdPublicacion(id);
    }
}
