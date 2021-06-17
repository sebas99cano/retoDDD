package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.events.*;
import co.com.sofka.blog.domain.usuario.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Usuario extends AggregateEvent<IdUsuario> {

    protected Suscripcion suscripcion;
    protected Persona persona;
    protected Cuenta cuenta;

    public Usuario(IdUsuario entityId, Suscripcion suscripcion, Persona persona, Cuenta cuenta) {
        super(entityId);
        Objects.requireNonNull(suscripcion);
        Objects.requireNonNull(persona);
        Objects.requireNonNull(cuenta);
        appendChange(new UsuarioCreado(suscripcion, persona, cuenta)).apply();
    }

    public Usuario(IdUsuario idUsuario){
        super(idUsuario);
        subscribe(new UsuarioChange(this));
    }

    public static Usuario from(IdUsuario idUsuario, List<DomainEvent> events){
        var usuario = new Usuario(idUsuario);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    public void modificarClaveUsuarioDeCuenta(ClaveUsuario claveUsuario){
        Objects.requireNonNull(claveUsuario);
        appendChange(new ClaveUsuarioDeCuentaModificado(claveUsuario)).apply();
    }

    public void modificarNombreDePersona(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreDePersonaModificado(nombre)).apply();
    }

    public void modificarTelefonoDePersona(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoDePersonaModificado(telefono)).apply();
    }

    public void aumentarRangoDeSuscripcion(){
        appendChange(new RangoDeSuscripcionAumentado(this.suscripcion.rango)).apply();
    }

    public void disminuirRangoDeSuscripcion(){
        appendChange(new RangoDeSuscripcionDisminuido(this.suscripcion.rango)).apply();
    }

    public void modificarPrecioDeSuscripcion(Precio precio){
        Objects.requireNonNull(precio);
        appendChange(new PrecioDeSuscripcionModificado(precio)).apply();
    }

    public Suscripcion suscripcion(){
        return this.suscripcion;
    }

    public Persona persona(){
        return this.persona;
    }

    public Cuenta cuenta(){
        return this.cuenta;
    }

}
