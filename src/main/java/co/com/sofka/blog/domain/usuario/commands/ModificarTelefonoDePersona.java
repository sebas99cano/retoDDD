package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.blog.domain.usuario.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class ModificarTelefonoDePersona implements Command {

    private final IdUsuario idUsuario;
    private final Telefono telefono;

    public ModificarTelefonoDePersona(IdUsuario idUsuario, Telefono telefono) {
        this.idUsuario = idUsuario;
        this.telefono = telefono;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
