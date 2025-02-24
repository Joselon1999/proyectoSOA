package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.soa.avance.model.Despacho;

import java.util.Optional;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho,Long> {

    Optional<Despacho> findByUuid(String uuid);
}
