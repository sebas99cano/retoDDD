package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ClaveUsuario;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.Command;

public class ModificarClaveUsuarioDeCuenta implements Command {

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
