package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntuacion implements ValueObject<Integer> {
    private final Integer puntuacion;

    public Puntuacion(Integer puntuacion) {

        if(puntuacion<1){
            throw new IllegalArgumentException("La puntuacion no es valido, debe ser un valor entre 1 y 5");
        }
        if(puntuacion>5){
            throw new IllegalArgumentException("La puntuacion no es valido, debe ser un valor entre 1 y 5");
        }

        this.puntuacion = Objects.requireNonNull(puntuacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuacion that = (Puntuacion) o;
        return Objects.equals(puntuacion, that.puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(puntuacion);
    }

    @Override
    public Integer value() {
        return puntuacion;
    }
}
