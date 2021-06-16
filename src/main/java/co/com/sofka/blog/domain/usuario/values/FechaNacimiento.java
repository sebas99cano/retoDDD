package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaNacimiento implements ValueObject<Date> {

    private final Date fechaNacimiento;

    public FechaNacimiento(Date fechaNacimiento) {
        //TODO:v validar la fecha
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaNacimiento that = (FechaNacimiento) o;
        return Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaNacimiento);
    }

    @Override
    public Date value() {
        return fechaNacimiento;
    }
}
