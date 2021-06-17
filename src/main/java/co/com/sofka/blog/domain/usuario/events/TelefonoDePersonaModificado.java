package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoDePersonaModificado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoDePersonaModificado(Telefono telefono) {
        super("blog.usuario.telefonodepersonamodificado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
