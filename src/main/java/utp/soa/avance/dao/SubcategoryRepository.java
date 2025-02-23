package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.soa.avance.model.Categoria;
import utp.soa.avance.model.Subcategoria;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategoria,Long> {
}
