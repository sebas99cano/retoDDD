package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class IdPersona extends Identity {
    public IdPersona(String uuid) {
        super(uuid);
    }

    public IdPersona() {
    }

    public static IdPersona of(String id){
        return new IdPersona(id);
    }
}
