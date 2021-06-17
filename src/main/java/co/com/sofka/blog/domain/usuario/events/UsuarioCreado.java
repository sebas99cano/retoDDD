package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCreado extends DomainEvent {


    private final Suscripcion suscripcion;
    private final Persona persona;
    private final Cuenta cuenta;

    public UsuarioCreado(Suscripcion suscripcion, Persona persona, Cuenta cuenta) {
        super("blog.usuario.usuariocreado");
        this.suscripcion = suscripcion;
        this.persona = persona;
        this.cuenta = cuenta;
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
