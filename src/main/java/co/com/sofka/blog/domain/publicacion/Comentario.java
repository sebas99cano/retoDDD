package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdComentario;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Comentario extends Entity<IdComentario> {

    protected Descripcion descripcion;
    protected Autor autor;

    public Comentario(IdComentario entityId, Descripcion descripcion, Autor autor) {
        super(entityId);
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public void modificarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion(){
        return this.descripcion;
    }

    public Autor autor(){
        return this.autor;
    }
}
