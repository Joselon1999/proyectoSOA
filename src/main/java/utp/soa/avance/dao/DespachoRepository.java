package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.soa.avance.model.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho,Long> {
}
