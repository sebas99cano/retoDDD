package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<String> {

    private final String value;

    public Precio(String value) {

        validarLongitudPrecio(value);

        validarNumeroPrecio(value);

        this.value = Objects.requireNonNull(value);
    }

    private void validarLongitudPrecio(String precio) {
        if(precio.length()<1){
            throw new IllegalArgumentException("El precio de la suscripcion debe tener mas de 1 caracter");
        }

        if(precio.length()>20){
            throw new IllegalArgumentException("El precio de la suscripcion no puede tener mas de 10 caracteres");
        }
    }

    private void validarNumeroPrecio(String precio) {
        try{
            var precioFloat = Float.parseFloat(precio);
            if(precioFloat<0){
                throw new IllegalArgumentException("El precio de la suscripcion no puede ser un valor negativo");
            }
        }catch (Exception e){
            throw new IllegalArgumentException("El precio no es un valor numerico valido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var precio1 = (Precio) o;
        return Objects.equals(value, precio1.value);
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
