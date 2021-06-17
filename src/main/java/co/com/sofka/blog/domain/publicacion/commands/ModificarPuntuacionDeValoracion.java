package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.publicacion.values.IdValoracion;
import co.com.sofka.blog.domain.publicacion.values.Puntuacion;
import co.com.sofka.domain.generic.Command;

public class ModificarPuntuacionDeValoracion implements Command {
    private final IdPublicacion idPublicacion;
    private final IdValoracion idValoracion;
    private final Puntuacion puntuacion;

    public ModificarPuntuacionDeValoracion(IdPublicacion idPublicacion, IdValoracion idValoracion, Puntuacion puntuacion) {
        this.idPublicacion = idPublicacion;
        this.idValoracion = idValoracion;
        this.puntuacion = puntuacion;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public IdValoracion getIdValoracion() {
        return idValoracion;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
