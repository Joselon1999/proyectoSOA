package utp.soa.avance.service;

import org.springframework.data.domain.Page;
import utp.soa.avance.dto.UseProductRequest;
import utp.soa.avance.model.Producto;

import java.util.Optional;

public interface ProductService {

    Page<Producto> listProductos(int pagina, int tamanio);

    Producto createProducto(Producto producto);

    Page<Producto> listarPorCategoria(Long categoria,int pagina, int tamanio);

    Optional<Producto> getProducto(Long id);

    Producto usarProducto(UseProductRequest request);

    Producto actualizarProducto(UseProductRequest request);
}
