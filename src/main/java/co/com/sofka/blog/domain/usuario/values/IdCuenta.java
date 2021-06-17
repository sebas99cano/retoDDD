package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class IdCuenta extends Identity {

    public IdCuenta(String uuid) {
        super(uuid);
    }

    public IdCuenta() {
    }

    public static IdCuenta of(String id){
        return new IdCuenta(id);
    }
}
