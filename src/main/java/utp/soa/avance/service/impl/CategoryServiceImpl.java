package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.CategoryRepository;
import utp.soa.avance.model.Categoria;
import utp.soa.avance.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categoria> listCategoria() {
        return categoryRepository.findAll();
    }
}
