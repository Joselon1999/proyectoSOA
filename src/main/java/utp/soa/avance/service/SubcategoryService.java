package utp.soa.avance.service;

import utp.soa.avance.model.Categoria;
import utp.soa.avance.model.Subcategoria;

import java.util.List;

public interface SubcategoryService {

    List<Subcategoria> listSubcategoria();

    Subcategoria getSubcategoria(Long id);
}
