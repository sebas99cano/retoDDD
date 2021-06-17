package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.events.*;
import co.com.sofka.domain.generic.EventChange;

public class UsuarioChange extends EventChange {
    public UsuarioChange(Usuario usuario) {

        apply((UsuarioCreado event)->{
            usuario.suscripcion = event.getSuscripcion();
            usuario.persona = event.getPersona();
            usuario.cuenta = event.getCuenta();
        });

        apply((ClaveUsuarioDeCuentaModificado event)->{
            usuario.cuenta.modificarClaveUsuario(event.getClaveUsuario());
        });

        apply((NombreDePersonaModificado event)->{
            usuario.persona.modificarNombre(event.getNombre());
        });

        apply((TelefonoDePersonaModificado event)->{
            usuario.persona.modificarTelefono(event.getTelefono());
        });

        apply((RangoDeSuscripcionAumentado event)->{
            usuario.suscripcion.aumentarRango(event.getRango());
        });

        apply((RangoDeSuscripcionDisminuido event)->{
            usuario.suscripcion.disminuirRango(event.getRango());
        });

        apply((PrecioDeSuscripcionModificado event)->{
            usuario.suscripcion.modificarPrecio(event.getPrecio());
        });

    }
}
