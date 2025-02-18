package utp.soa.avance.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utp.soa.avance.model.Producto;

public interface ProductRepository extends JpaRepository<Producto,Long> {

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 0.0 AND p.estado_producto = 'true'")
    Page<Producto> findProductosConStock(Double cantidad,PageRequest e);

    @Query("SELECT p FROM Producto p " +
            "WHERE p.categoria.id = :categoriaId " +
            "AND p.cantidad > :cantidad " +
            "AND p.estado_producto = 'true'")
    Page<Producto> findProductosSinStock(@Param("categoriaId") Long categoriaId, @Param("cantidad") Double cantidad, Pageable pageable);
}
