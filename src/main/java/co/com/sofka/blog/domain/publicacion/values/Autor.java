package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.blog.domain.usuario.values.IdUsuario;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Autor implements ValueObject<Autor.Props> {

    private final IdUsuario idUsuario;
    private final String nombre;

    public Autor(IdUsuario idUsuario, String nombre) {
        this.idUsuario = Objects.requireNonNull(idUsuario);
        this.nombre = Objects.requireNonNull(nombre);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public IdUsuario idUsuario() {
                return idUsuario;
            }

            @Override
            public String nombre() {
                return nombre;
            }
        };
    }

    public interface  Props{
        IdUsuario idUsuario();
        String nombre();
    }

}
