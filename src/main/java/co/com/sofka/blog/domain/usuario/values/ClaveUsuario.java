package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ClaveUsuario implements ValueObject<String> {

    private final String claveUsuario;

    public ClaveUsuario(String claveUsuario) {

        if(claveUsuario.length()<8){
            throw new IllegalArgumentException("la clave de usuario no puede ser menor a 8 caracteres");
        }

        if(claveUsuario.length()>20){
            throw new IllegalArgumentException("la clave de usuario no puede ser mayor a 20 caracteres");
        }

        this.claveUsuario = Objects.requireNonNull(claveUsuario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaveUsuario that = (ClaveUsuario) o;
        return Objects.equals(claveUsuario, that.claveUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claveUsuario);
    }

    @Override
    public String value() {
        return null;
    }
}
