package utp.soa.avance.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.UseProductRequest;
import utp.soa.avance.model.Producto;
import utp.soa.avance.model.Usuario;
import utp.soa.avance.service.CategoryService;
import utp.soa.avance.service.ProductService;
import utp.soa.avance.service.SubcategoryService;
import utp.soa.avance.service.UserService;
import utp.soa.avance.service.session.IAuthenticationFacade;

import java.time.ZoneId;
import java.util.Date;

@Controller
@Slf4j
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/helper/gestion-productos")
    public String gestionProductos(@RequestParam(defaultValue = "1") int pagina,
                                   @RequestParam(defaultValue = "5") int tamanio,
                                   @RequestParam(value = "categoria", required = false) Long idCategoria,
                                   Model model) {

        if (idCategoria != null) {
            Page<Producto> list = productService.listarPorCategoria(idCategoria,pagina, tamanio);
            model.addAttribute("alimentos", list.getContent());
            model.addAttribute("totalPaginas", list.getTotalPages());
            log.info("Categoria: {}",idCategoria);
        } else {
            Page<Producto> list = productService.listProductos(pagina, tamanio);
            model.addAttribute("alimentos", list.getContent());
            model.addAttribute("totalPaginas", list.getTotalPages());
            log.info("Sin Categoria");
        }

        model.addAttribute("paginaActual", pagina);
        model.addAttribute("categorias", categoryService.listCategoria());
        return "mainProductos";
    }
    @GetMapping("/admin/gestion-productos/alimentos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alimento", new Producto());
        model.addAttribute("categorias", categoryService.listCategoria());
        model.addAttribute("subcategorias", subcategoryService.listSubcategoria());
        return "createProducto";
    }

    @PostMapping("/admin/gestion-productos/alimentos/nuevo")
    public String registrarAlimento(@Valid @ModelAttribute("alimento") Producto producto,
                              BindingResult bindingResult,
                              Model model) {
        Usuario u = userService.getUsuario(authenticationFacade.getAuthentication().getName()).get();
        producto.setUsuario(u);
        producto.setEstado_producto("true");
        if (bindingResult.hasErrors()) {
            model.addAttribute("alimento", new Producto());
            model.addAttribute("categorias", categoryService.listCategoria());
            return "createProducto";
        }
        productService.createProducto(producto);
        return "redirect:/helper/gestion-productos";
    }

    @GetMapping("/helper/gestion-productos/{id}/usar")
    public String usarProducto(@PathVariable Long id,Model model) {
        UseProductRequest request = new UseProductRequest();
        request.setProductId(id);

        model.addAttribute("product", productService.getProducto(id));
        model.addAttribute("request", request);
        return "usarProducto";
    }

    @PostMapping("/helper/gestion-productos/usar")
    public String registrarUsoProducto(@ModelAttribute("request") UseProductRequest request,
                                       BindingResult bindingResult,
                                       Model model) {
        Producto producto = productService.getProducto(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (request.getCantidad() > producto.getCantidad()) {
            model.addAttribute("product", productService.getProducto(request.getProductId()));
            model.addAttribute("request", request);
            model.addAttribute("mensaje", "La cantidad solicitada supera el stock disponible.");
            return "usarProducto";
        }
        productService.usarProducto(request);
        return "redirect:/helper/gestion-productos";
    }


    @GetMapping("/admin/gestion-productos/{id}/modificar")
    public String actualizarProducto(@PathVariable Long id,Model model) {
        Producto producto = productService.getProducto(id).get();
        UseProductRequest request = new UseProductRequest();
        request.setProductId(id);
        request.setCantidad(producto.getCantidad());
        request.setEnabled(producto.getEstado_producto().equals("true"));


        model.addAttribute("product", producto);
        model.addAttribute("request", request);
        return "updateProducto";
    }

    @PostMapping("/admin/gestion-productos/modificar")
    public String registrarActualizarProductoProducto(@ModelAttribute("request") UseProductRequest request,
                                       BindingResult bindingResult,
                                       Model model) {
        Producto producto = productService.getProducto(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        productService.actualizarProducto(request);
        return "redirect:/helper/gestion-productos";
    }
}
