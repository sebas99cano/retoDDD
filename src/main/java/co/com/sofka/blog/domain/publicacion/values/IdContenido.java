package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdContenido extends Identity {
    public IdContenido(String uuid) {
        super(uuid);
    }

    public IdContenido() {
    }

    public static IdContenido of(String id){
        return new IdContenido(id);
    }
}
