package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.soa.avance.model.Transportista;

import java.util.Optional;

public interface TransportistaRepository extends JpaRepository<Transportista,Long> {

    Optional<Transportista> findById(Long id);
}
