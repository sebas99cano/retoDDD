package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String telefono;

    public Telefono(String telefono) {
        if(telefono.length()<7){
            throw new IllegalArgumentException("El telefono no puede ser menor a 8 caracteres");
        }

        if(telefono.length()>15){
            throw new IllegalArgumentException("El telefono no puede ser mayor a 15 caracteres");
        }
        this.telefono = Objects.requireNonNull(telefono);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono1 = (Telefono) o;
        return Objects.equals(telefono, telefono1.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono);
    }

    @Override
    public String value() {
        return telefono;
    }
}
