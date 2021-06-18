package co.com.sofka.blog.usecase.notificar;

import co.com.sofka.blog.domain.usuario.values.Correo;

public interface SenderEmailService {
    void sendEmail(Correo email, String valoracion_agregada);
}
