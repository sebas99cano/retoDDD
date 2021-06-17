package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.domain.generic.Command;

public class ModificarPrecioDeSuscripcion implements Command {

    private final IdUsuario idUsuario;
    private final Precio precio;

    public ModificarPrecioDeSuscripcion(IdUsuario idUsuario, Precio precio) {
        this.idUsuario = idUsuario;
        this.precio = precio;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Precio getPrecio() {
        return precio;
    }
}

