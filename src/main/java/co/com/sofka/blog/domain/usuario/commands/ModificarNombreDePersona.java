package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.blog.domain.usuario.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ModificarNombreDePersona implements Command {

    private final IdUsuario idUsuario;
    private final Nombre nombre;

    public ModificarNombreDePersona(IdUsuario idUsuario, Nombre nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
