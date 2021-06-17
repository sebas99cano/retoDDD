package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class ModificarTituloDeContenido implements Command {
    private final IdPublicacion idPublicacion;
    private final Titulo titulo;

    public ModificarTituloDeContenido(IdPublicacion idPublicacion, Titulo titulo) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
