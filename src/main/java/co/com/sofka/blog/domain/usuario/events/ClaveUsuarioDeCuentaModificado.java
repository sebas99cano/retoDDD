package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.ClaveUsuario;
import co.com.sofka.domain.generic.DomainEvent;

public class ClaveUsuarioDeCuentaModificado extends DomainEvent {

    private final ClaveUsuario claveUsuario;

    public ClaveUsuarioDeCuentaModificado(ClaveUsuario claveUsuario) {
        super("blog.usuario.claveusuariodecuentamodificado");
        this.claveUsuario = claveUsuario;
    }

    public ClaveUsuario getClaveUsuario() {
        return claveUsuario;
    }
}
