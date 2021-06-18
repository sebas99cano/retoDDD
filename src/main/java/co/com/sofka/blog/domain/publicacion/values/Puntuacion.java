package co.com.sofka.blog.domain.publicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntuacion implements ValueObject<Integer> {
    private final Integer value;

    public Puntuacion(Integer value) {

        if(value <1){
            throw new IllegalArgumentException("La puntuacion no es valido, debe ser un valor entre 1 y 5");
        }
        if(value >5){
            throw new IllegalArgumentException("La puntuacion no es valido, debe ser un valor entre 1 y 5");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuacion that = (Puntuacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
