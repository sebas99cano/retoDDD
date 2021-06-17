package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.Command;

public class CrearUsuario implements Command {

    private final IdUsuario idUsuario;
    private final Suscripcion suscripcion;
    private final Persona persona;
    private final Cuenta cuenta;

    public CrearUsuario(IdUsuario idUsuario, Suscripcion suscripcion, Persona persona, Cuenta cuenta) {
        this.idUsuario = idUsuario;
        this.suscripcion = suscripcion;
        this.persona = persona;
        this.cuenta = cuenta;
    }

    public IdUsuario getIdUsuario() {
        return idUsuario;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
