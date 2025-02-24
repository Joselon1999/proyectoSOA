package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.soa.avance.model.ProductoCantidad;

import java.util.List;

@Repository
public interface ProductoCantidadRepository extends JpaRepository<ProductoCantidad,Long> {

    List<ProductoCantidad> findByUuid(String uuid);
}
