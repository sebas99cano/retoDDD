package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Correo implements ValueObject<String> {

    private final String value;

    public Correo(String value) {

        if(value.length()<10){
            throw new IllegalArgumentException("El correo no puede ser menor a 10 caracteres");
        }

        if(value.length()>100){
            throw new IllegalArgumentException("El correo no puede ser mayor a 100 caracteres");
        }
        //validar el correo
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(value);
        if(!mather.find()){
            throw new IllegalArgumentException("El correo ingresado no es valido");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var correo1 = (Correo) o;
        return Objects.equals(value, correo1.value);
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
