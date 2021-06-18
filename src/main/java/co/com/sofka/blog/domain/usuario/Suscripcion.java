package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.values.IdSuscripcion;
import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.blog.domain.usuario.values.Rango;
import co.com.sofka.domain.generic.Entity;

public class Suscripcion extends Entity<IdSuscripcion>{

    protected Precio precio;
    protected Rango rango;

    public Suscripcion(IdSuscripcion entityId,Precio precio, Rango rango) {
        super(entityId);
        this.precio = precio;
        this.rango = rango;
    }

    public void aumentarRango(Rango rango){
        this.rango = rango;
    }

    public void disminuirRango(Rango rango){
        this.rango = rango;
    }

    public void modificarPrecio(Precio precio){
        this.precio = precio;
    }

    public Precio precio(){
        return this.precio;
    }

    public Rango rango(){
        return this.rango;
    }
}
