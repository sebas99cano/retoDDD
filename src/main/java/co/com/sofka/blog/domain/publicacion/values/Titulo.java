package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Titulo implements ValueObject<String> {

    private final String titulo;

    public Titulo(String titulo) {

        if(titulo.length()<3){
            throw new IllegalArgumentException("El titulo no puede ser menor a 3 caracteres");
        }

        if(titulo.length()>30){
            throw new IllegalArgumentException("El titulo no puede ser mayor a 30 caracteres");
        }

        this.titulo = Objects.requireNonNull(titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titulo titulo1 = (Titulo) o;
        return Objects.equals(titulo, titulo1.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    @Override
    public String value() {
        return titulo;
    }
}
