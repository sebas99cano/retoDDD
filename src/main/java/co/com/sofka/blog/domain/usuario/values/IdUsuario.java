package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class IdUsuario extends Identity {
    public IdUsuario(String uuid) {
        super(uuid);
    }

    public IdUsuario() {
    }

    public static IdUsuario of(String id){
        return new IdUsuario(id);
    }
}
