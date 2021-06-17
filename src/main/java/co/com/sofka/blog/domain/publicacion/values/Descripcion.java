package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {

        if(descripcion.length()<20){
            throw new IllegalArgumentException("La descripcion no puede ser menor a 20 caracteres");
        }

        if(descripcion.length()>300){
            throw new IllegalArgumentException("La descripcion no puede ser mayor a 300 caracteres");
        }

        this.descripcion = Objects.requireNonNull(descripcion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }

    @Override
    public String value() {
        return null;
    }
}
