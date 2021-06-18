package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Titulo implements ValueObject<String> {

    private final String value;

    public Titulo(String value) {

        if(value.length()<3){
            throw new IllegalArgumentException("El titulo no puede ser menor a 3 caracteres");
        }

        if(value.length()>30){
            throw new IllegalArgumentException("El titulo no puede ser mayor a 30 caracteres");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var titulo1 = (Titulo) o;
        return Objects.equals(value, titulo1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
