package co.com.sofka.blog.domain.publicacion.commands;

import co.com.sofka.blog.domain.publicacion.values.Descripcion;
import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionDeContenido implements Command {
    private final IdPublicacion idPublicacion;
    private final Descripcion descripcion;

    public ModificarDescripcionDeContenido(IdPublicacion idPublicacion, Descripcion descripcion) {
        this.idPublicacion = idPublicacion;
        this.descripcion = descripcion;
    }

    public IdPublicacion getIdPublicacion() {
        return idPublicacion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
