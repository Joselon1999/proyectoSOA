package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.soa.avance.model.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria,Long> {
}
