package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.CategoryRepository;
import utp.soa.avance.dao.SubcategoryRepository;
import utp.soa.avance.model.Categoria;
import utp.soa.avance.model.Subcategoria;
import utp.soa.avance.service.CategoryService;
import utp.soa.avance.service.SubcategoryService;

import java.util.List;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public List<Subcategoria> listSubcategoria() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategoria getSubcategoria(Long id) {
        return subcategoryRepository.getReferenceById(id);
    }
}
