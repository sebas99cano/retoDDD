package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Correo implements ValueObject<String> {

    private final String correo;

    public Correo(String correo) {

        if(correo.length()<15){
            throw new IllegalArgumentException("El correo no puede ser menor a 15 caracteres");
        }

        if(correo.length()>75){
            throw new IllegalArgumentException("El correo no puede ser mayor a 75 caracteres");
        }
        this.correo = Objects.requireNonNull(correo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var correo1 = (Correo) o;
        return Objects.equals(correo, correo1.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    @Override
    public String value() {
        return correo;
    }
}
