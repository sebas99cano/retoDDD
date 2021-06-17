package co.com.sofka.blog.domain.publicacion.events;

import co.com.sofka.blog.domain.publicacion.values.Titulo;
import co.com.sofka.domain.generic.DomainEvent;

public class TituloDeContenidoModificado extends DomainEvent {

    private final Titulo titulo;

    public TituloDeContenidoModificado(Titulo titulo) {
        super("blog.publicacion.titulodecontenidomodificado");
        this.titulo = titulo;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
