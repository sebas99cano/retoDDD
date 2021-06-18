package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.usuario.values.Correo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;

public interface ValoracionService {
    Correo getCorreoPorIdUsuario(IdUsuario idUsuario);
}
