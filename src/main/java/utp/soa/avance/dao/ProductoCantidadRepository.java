package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.soa.avance.model.ProductoCantidad;

@Repository
public interface ProductoCantidadRepository extends JpaRepository<ProductoCantidad,Long> {
}
