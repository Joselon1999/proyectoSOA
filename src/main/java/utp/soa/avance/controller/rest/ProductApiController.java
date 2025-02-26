package utp.soa.avance.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.ActualizarProductoRequest;
import utp.soa.avance.dto.CrearProductoRequest;
import utp.soa.avance.dto.CrearProductoResponse;
import utp.soa.avance.model.Producto;
import utp.soa.avance.service.CategoryService;
import utp.soa.avance.service.ProductService;
import utp.soa.avance.service.SubcategoryService;
import utp.soa.avance.service.UserService;

import java.util.List;
import java.util.Optional;


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
    @Operation(summary = "Listar los productos recepcionados de la fabrica para enviar a las sedes de Calimod")
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

    @PostMapping
    @Operation(summary = "Crear productos recepcionados")
    public ResponseEntity<CrearProductoResponse> createProductos(CrearProductoRequest request) {

        Producto p = new Producto();
        p.setCantidad(request.getCantidad());
        p.setUsuario(userService.getUsuario("u19300224@utp.edu.pe").get());
        p.setEstado_producto("true");
        p.setDesc_producto(request.getDesc_producto());
        p.setCategoria(categoryService.getCategoria(request.getCategoria()));
        p.setSubcategoria(subcategoryService.getSubcategoria(request.getSubcategoria()));
        Producto producto =productService.createProducto(p);

        return ResponseEntity.ok(CrearProductoResponse.builder()
                .id_producto(producto.getId_producto())
                .desc_producto(producto.getDesc_producto())
                .estado_producto(producto.getEstado_producto())
                .categoria(producto.getCategoria().getNombre())
                .subcategoria(producto.getSubcategoria().getNombre())
                .cantidad(producto.getCantidad())
                .fecha_ingreso(producto.getFecha_ingreso())
                .build());
    }

    @PutMapping
    @Operation(summary = "Actualizar productos")
    public ResponseEntity<CrearProductoResponse> updateProductos(ActualizarProductoRequest request) {

        Optional<Producto> product = productService.getProducto(request.getId());
        if (product.isPresent()) {
            Producto p =product.get();
            p.setCantidad(request.getCantidad());
            p.setUsuario(userService.getUsuario("u19300224@utp.edu.pe").get());
            p.setEstado_producto("true");
            p.setDesc_producto(request.getDesc_producto());
            p.setCategoria(categoryService.getCategoria(request.getCategoria()));
            p.setSubcategoria(subcategoryService.getSubcategoria(request.getSubcategoria()));
            Producto producto =productService.createProducto(p);

            return ResponseEntity.ok(CrearProductoResponse.builder()
                    .id_producto(producto.getId_producto())
                    .desc_producto(producto.getDesc_producto())
                    .estado_producto(producto.getEstado_producto())
                    .categoria(producto.getCategoria().getNombre())
                    .subcategoria(producto.getSubcategoria().getNombre())
                    .cantidad(producto.getCantidad())
                    .fecha_ingreso(producto.getFecha_ingreso())
                    .build());
        } else {
            return (ResponseEntity<CrearProductoResponse>) ResponseEntity.notFound();
        }

    }
}
