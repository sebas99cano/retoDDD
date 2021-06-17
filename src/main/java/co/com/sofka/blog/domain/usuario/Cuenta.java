package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.values.ClaveUsuario;
import co.com.sofka.blog.domain.usuario.values.IdCuenta;
import co.com.sofka.blog.domain.usuario.values.NombreUsuario;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cuenta extends Entity<IdCuenta> {

    protected ClaveUsuario claveUsuario;
    protected NombreUsuario nombreUsuario;

    public Cuenta(IdCuenta entityId, ClaveUsuario claveUsuario, NombreUsuario nombreUsuario) {
        super(entityId);
        this.claveUsuario = claveUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public void modificarClaveUsuario(ClaveUsuario claveUsuario){
        this.claveUsuario = Objects.requireNonNull(claveUsuario);
    }

    public ClaveUsuario claveUsuario(){
        return this.claveUsuario;
    }

    public NombreUsuario nombreUsuario(){
        return this.nombreUsuario;
    }
}
