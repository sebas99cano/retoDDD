package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ClaveUsuario implements ValueObject<String> {

    private final String value;

    public ClaveUsuario(String value) {

        if(value.length()<8){
            throw new IllegalArgumentException("La clave de usuario no puede ser menor a 8 caracteres");
        }

        if(value.length()>20){
            throw new IllegalArgumentException("La clave de usuario no puede ser mayor a 20 caracteres");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaveUsuario that = (ClaveUsuario) o;
        return Objects.equals(value, that.value);
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
