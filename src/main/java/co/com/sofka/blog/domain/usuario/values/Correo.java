package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject<String> {

    private final String value;

    public Correo(String value) {

        if(value.length()<15){
            throw new IllegalArgumentException("El correo no puede ser menor a 15 caracteres");
        }

        if(value.length()>75){
            throw new IllegalArgumentException("El correo no puede ser mayor a 75 caracteres");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var correo1 = (Correo) o;
        return Objects.equals(value, correo1.value);
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
