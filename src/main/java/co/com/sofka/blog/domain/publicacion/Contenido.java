package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.IdContenido;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Contenido extends Entity<IdContenido> {

    protected Titulo titulo;
    protected Contenido contenido;

    public Contenido(IdContenido entityId, Titulo titulo, Contenido contenido) {
        super(entityId);
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public void modificarTitulo(Titulo titulo){
        this.titulo = Objects.requireNonNull(titulo);
    }

    public void modificarContenido(Contenido contenido){
        this.contenido = Objects.requireNonNull(contenido);
    }

    public Titulo titulo(){
        return this.titulo;
    }

    public Contenido contenido(){
        return this.contenido;
    }
}
