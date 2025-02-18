package utp.soa.avance.service;

import org.springframework.data.domain.Page;
import utp.soa.avance.dto.UseUserRequest;
import utp.soa.avance.model.Usuario;

import java.util.Optional;

public interface UserService {

    Optional<Usuario> getUsuario(String email);
    Page<Usuario> listUsuario(int pagina, int tamanio);

    Usuario createUser(Usuario usuario);

    Usuario updateUser(UseUserRequest request);

    Usuario updateUser(Usuario usuario);
}
