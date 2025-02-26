package utp.soa.avance.service;

import utp.soa.avance.model.Categoria;

import java.util.List;

public interface CategoryService {

    List<Categoria> listCategoria();

    Categoria getCategoria(Long id);
}
