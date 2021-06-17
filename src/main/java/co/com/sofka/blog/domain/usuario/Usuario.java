package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Usuario extends AggregateEvent<IdUsuario> {

    protected Suscripcion suscripcion;
    protected Persona persona;
    protected Cuenta cuenta;

    public Usuario(IdUsuario entityId, Suscripcion suscripcion, Persona persona, Cuenta cuenta) {
        super(entityId);
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
