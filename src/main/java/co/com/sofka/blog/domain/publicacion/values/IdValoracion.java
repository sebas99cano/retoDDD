package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdValoracion extends Identity {
    public IdValoracion(String uuid) {
        super(uuid);
    }

    public IdValoracion() {
    }
    public static IdValoracion of(String id){
        return new IdValoracion(id);
    }
}
