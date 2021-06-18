package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value) {
        if(value.length()<7){
            throw new IllegalArgumentException("El telefono no puede ser menor a 8 caracteres");
        }

        if(value.length()>15){
            throw new IllegalArgumentException("El telefono no puede ser mayor a 15 caracteres");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var telefono1 = (Telefono) o;
        return Objects.equals(value, telefono1.value);
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
