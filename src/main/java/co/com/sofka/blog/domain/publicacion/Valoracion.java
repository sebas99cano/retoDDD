package co.com.sofka.blog.domain.publicacion;

import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Valoracion extends Entity<IdValoracion> {

    protected Autor autor;
    protected Puntuacion puntuacion;

    public Valoracion(IdValoracion entityId, Autor autor, Puntuacion puntuacion) {
        super(entityId);
        this.autor = autor;
        this.puntuacion = puntuacion;
    }

    public void modificarPuntuacion(Puntuacion puntuacion){
        this.puntuacion = Objects.requireNonNull(puntuacion);
    }

    public Autor Autor() {
        return this.autor;
    }

    public Puntuacion Puntuacion() {
        return this.puntuacion;
    }
}
