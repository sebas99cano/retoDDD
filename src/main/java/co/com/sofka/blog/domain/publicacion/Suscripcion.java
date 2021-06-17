package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.IdSuscripcion;
import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.blog.domain.usuario.values.Rango;
import co.com.sofka.domain.generic.Entity;

public class Suscripcion extends Entity<IdSuscripcion> {

    protected Precio precio;
    protected Rango rango;

    public Suscripcion(IdSuscripcion entityId,Precio precio, Rango rango) {
        super(entityId);
        this.precio = precio;
        this.rango = rango;
    }

    public void aumentarRango(){
        this.rango = this.rango.aumentar();
    }

    public void disminuirRango(){
        this.rango = this.rango.disminuir();
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
