package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ClaveUsuario;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;

public class ModificarClaveUsuarioDeCuenta {

    private final IdUsuario idUsuario;
    private final ClaveUsuario claveUsuario;

    public ModificarClaveUsuarioDeCuenta(IdUsuario idUsuario, ClaveUsuario claveUsuario) {
        this.idUsuario = idUsuario;
        this.claveUsuario = claveUsuario;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public ClaveUsuario getClaveUsuario() {
        return claveUsuario;
    }
}
