package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rango implements ValueObject<Integer> {
    private final Integer rango;

    public Rango(Integer rango) {

        if(rango<1){
            throw new IllegalArgumentException("El rango no es valido, debe ser un valor entre 1 y 3");
        }
        if(rango>3){
            throw new IllegalArgumentException("El rango no es valido, debe ser un valor entre 1 y 3");
        }

        this.rango = Objects.requireNonNull(rango);
    }

    public Rango aumentar(){
        return new Rango((this.rango+1));
    }

    public Rango disminuir(){
        return new Rango((this.rango-1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rango rango1 = (Rango) o;
        return Objects.equals(rango, rango1.rango);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rango);
    }

    @Override
    public Integer value() {
        return rango;
    }
}
