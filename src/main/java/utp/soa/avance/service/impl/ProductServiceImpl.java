package utp.soa.avance.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.HistoricoAlimentariaRepository;
import utp.soa.avance.dao.ProductRepository;
import utp.soa.avance.dao.UserRepository;
import utp.soa.avance.dto.UseProductRequest;
import utp.soa.avance.model.HistoricoAlimentaria;
import utp.soa.avance.model.Producto;
import utp.soa.avance.model.Usuario;
import utp.soa.avance.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoricoAlimentariaRepository historicoAlimentariaRepository;

    @Override
    public Page<Producto> listProductos(int pagina, int tamanio) {
        return productRepository.findProductosConStock(0.0,PageRequest.of(pagina-1,tamanio));
    }

    @Override
    public Producto createProducto(Producto producto) {

        Usuario u = userRepository.findById(producto.getUsuario().getId_usuario())
                .orElse(new Usuario());
        producto.setUsuario(u);

        producto.setFecha_ingreso(LocalDate.now());

        Producto p = productRepository.save(producto);

        HistoricoAlimentaria h = new HistoricoAlimentaria();
        h.setProducto(p);
        h.setFecha_uso(LocalDate.now());
        h.setCantidad("-".concat(String.valueOf(producto.getCantidad())));
        historicoAlimentariaRepository.save(h);
        return p;
    }

    @Override
    public Page<Producto> listarPorCategoria(Long categoria, int pagina, int tamanio) {
        return productRepository.findProductosSinStock(
                categoria,0.0,PageRequest.of(pagina-1,tamanio));
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Producto usarProducto(UseProductRequest request) {
        Optional<Producto> producto = productRepository.findById(request.getProductId());
        Producto p = new Producto();

        if (producto.isPresent()) {
            p = producto.get();
            p.setCantidad(p.getCantidad() - request.getCantidad());
            productRepository.save(p);

            HistoricoAlimentaria h = new HistoricoAlimentaria();
            h.setProducto(p);
            h.setFecha_uso(LocalDate.now());
            h.setCantidad(String.valueOf(request.getCantidad()));
            historicoAlimentariaRepository.save(h);
        } else {
            log.warn("Request modificado: {} - {}",request.getProductId(),request.getCantidad());
        }
        return p;
    }

    @Override
    public Producto actualizarProducto(UseProductRequest request) {
        Optional<Producto> producto = productRepository.findById(request.getProductId());
        Producto p = new Producto();

        if (producto.isPresent()) {
            p = producto.get();
            if (!request.getEnabled()) {
                p.setEstado_producto(String.valueOf(request.getEnabled()));
            }
            p.setCantidad(request.getCantidad());
            productRepository.save(p);
        } else {
            log.warn("Request modificado: {} - {}",request.getProductId(),request.getCantidad());
        }
        return p;
    }

    @Override
    public List<Producto> listAll() {
        return productRepository.findAll();
    }
}
