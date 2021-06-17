package co.com.sofka.blog.usecase.usuario;

import co.com.sofka.blog.domain.usuario.Cuenta;
import co.com.sofka.blog.domain.usuario.Persona;
import co.com.sofka.blog.domain.usuario.Suscripcion;
import co.com.sofka.blog.domain.usuario.commands.CrearUsuario;
import co.com.sofka.blog.domain.usuario.events.UsuarioCreado;
import co.com.sofka.blog.domain.usuario.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


class CrearUsuarioUseCaseTest {

    private CrearUsuarioUseCase crearUsuarioUseCase;

    @BeforeEach
    public void setup(){
        crearUsuarioUseCase = new CrearUsuarioUseCase();
    }

    @Test
    void crearUsuarioHappyPath(){
        //arrange
        var command = new CrearUsuario(
                IdUsuario.of("xxx-xxx"),
                new Suscripcion(new IdSuscripcion("xxx-xx1"),
                        new Precio("50000"),
                        new Rango(1)),
                new Persona(new IdPersona("xxx-xx2"),
                        new FechaNacimiento(new Date(100,5,3)),
                        new Nombre("Sebastian cano grajales"),
                        new Correo("sebas99cano@gmail.com"),
                        new Telefono("3058935891")),
                new Cuenta(new IdCuenta("xxx-xx3"),
                        new ClaveUsuario("clave123"),
                        new NombreUsuario("sebas99cano"))
        );

        //act
        var response=UseCaseHandler.getInstance().syncExecutor(crearUsuarioUseCase, new RequestCommand<>(command)).orElseThrow();

        var events = response.getDomainEvents();

        //asserts
        UsuarioCreado usuarioCreado = (UsuarioCreado)events.get(0);
        Assertions.assertEquals("Sebastian cano grajales",usuarioCreado.getPersona().nombre().value());
    }

}