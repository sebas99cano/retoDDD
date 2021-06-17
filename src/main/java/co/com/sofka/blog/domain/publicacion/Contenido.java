package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdContenido;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Contenido extends Entity<IdContenido> {

    protected Titulo titulo;
    protected Descripcion descripcion;

    public Contenido(IdContenido entityId, Titulo titulo, Descripcion descripcion) {
        super(entityId);
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public void modificarTitulo(Titulo titulo){
        this.titulo = Objects.requireNonNull(titulo);
    }

    public void modificarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Titulo titulo(){
        return this.titulo;
    }

    public Descripcion descripcion(){
        return this.descripcion;
    }
}
