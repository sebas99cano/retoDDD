package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.blog.domain.usuario.values.Precio;

public class ModificarPrecioDeSuscripcion {

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

