package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.Autor;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
import co.com.sofka.domain.generic.Command;

public class AgregarValoracion implements Command {
    private final IdPublicacion idPublicacion;
    private final IdValoracion idValoracion;
    private final Autor autor;
    private final Puntuacion puntuacion;

    public AgregarValoracion(IdPublicacion idPublicacion, IdValoracion idValoracion, Autor autor, Puntuacion puntuacion) {
        this.idPublicacion = idPublicacion;
        this.idValoracion = idValoracion;
        this.autor = autor;
        this.puntuacion = puntuacion;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public IdValoracion getIdValoracion() {
        return idValoracion;
    }

    public Autor getAutor() {
        return autor;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
