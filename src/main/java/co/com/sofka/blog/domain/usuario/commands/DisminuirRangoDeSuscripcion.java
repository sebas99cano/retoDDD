package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.blog.domain.usuario.values.Rango;

public class DisminuirRangoDeSuscripcion {

    private final IdUsuario idUsuario;
    private final Rango rango;

    public DisminuirRangoDeSuscripcion(IdUsuario idUsuario, Rango rango) {
        this.idUsuario = idUsuario;
        this.rango = rango;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Rango getRango() {
        return rango;
    }
}
