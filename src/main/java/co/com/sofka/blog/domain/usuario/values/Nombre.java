package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        if(value.length()<5){
            throw new IllegalArgumentException("El nombre no puede ser menor a 5 caracteres");
        }

        if(value.length()>75){
            throw new IllegalArgumentException("El nombre no puede ser mayor a 100 caracteres");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var nombre1 = (Nombre) o;
        return Objects.equals(value, nombre1.value);
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
