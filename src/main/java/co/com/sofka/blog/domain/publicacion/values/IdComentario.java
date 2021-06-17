package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdComentario extends Identity {
    public IdComentario(String uuid) {
        super(uuid);
    }

    public IdComentario() {
    }

    public static IdComentario of(String id){
        return new IdComentario(id);
    }
}
