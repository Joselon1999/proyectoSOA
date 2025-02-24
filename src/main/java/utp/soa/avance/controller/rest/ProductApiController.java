package utp.soa.avance.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.soa.avance.model.Producto;
import utp.soa.avance.service.CategoryService;
import utp.soa.avance.service.ProductService;
import utp.soa.avance.service.SubcategoryService;
import utp.soa.avance.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/productos")
@Slf4j
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Producto>> listProductos(
            @RequestParam(defaultValue = "1") int pagina,
            @RequestParam(defaultValue = "5") int tamanio,
            @RequestParam(value = "categoria", required = false) Long idCategoria) {

        Page<Producto> productos;

        if (idCategoria != null) {
            productos = productService.listarPorCategoria(idCategoria, pagina, tamanio);
            log.info("Categoría: {}", idCategoria);
        } else {
            productos = productService.listProductos(pagina, tamanio);
            log.info("Sin categoría");
        }

        return ResponseEntity.ok(productos.getContent());
    }

}
