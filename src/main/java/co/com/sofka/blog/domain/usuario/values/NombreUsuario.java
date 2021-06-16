package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreUsuario implements ValueObject<String> {

    private final String nombreUsuario;

    public NombreUsuario(String nombreUsuario) {

        if(nombreUsuario.length()<8){
            throw new IllegalArgumentException("El nombre de usuario no puede ser menor a 8 caracteres");
        }

        if(nombreUsuario.length()>20){
            throw new IllegalArgumentException("El nombre de usuario no puede ser mayor a 20 caracteres");
        }

        this.nombreUsuario = Objects.requireNonNull(nombreUsuario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreUsuario that = (NombreUsuario) o;
        return Objects.equals(nombreUsuario, that.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario);
    }

    @Override
    public String value() {
        return nombreUsuario;
    }
}
