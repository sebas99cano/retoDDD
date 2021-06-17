package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdPublicacion extends Identity {
    public IdPublicacion(String uuid) {
        super(uuid);
    }

    public IdPublicacion() {
    }

    public static IdPublicacion of(String id){return  new IdPublicacion(id);}
}
