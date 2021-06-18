package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rango implements ValueObject<Integer> {
    private final Integer value;

    public Rango(Integer value) {

        if(value <1){
            throw new IllegalArgumentException("El rango no es valido, debe ser un valor entre 1 y 3");
        }
        if(value >3){
            throw new IllegalArgumentException("El rango no es valido, debe ser un valor entre 1 y 3");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var rango1 = (Rango) o;
        return Objects.equals(value, rango1.value);
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
