package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.usuario.values.Correo;
import co.com.sofka.blog.domain.usuario.values.IdUsuario;

public interface ComnetarioService {
    Correo getCorreoPorIdUsuario(IdUsuario idUsuario);
}
