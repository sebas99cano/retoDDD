package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) {
        if(nombre.length()<15){
            throw new IllegalArgumentException("El nombre no puede ser menor a 15 caracteres");
        }

        if(nombre.length()>75){
            throw new IllegalArgumentException("El nombre no puede ser mayor a 100 caracteres");
        }
        this.nombre = Objects.requireNonNull(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre1 = (Nombre) o;
        return Objects.equals(nombre, nombre1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String value() {
        return nombre;
    }
}
