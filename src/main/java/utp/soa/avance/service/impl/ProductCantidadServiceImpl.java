package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.ProductRepository;
import utp.soa.avance.dao.ProductoCantidadRepository;
import utp.soa.avance.dto.ProductoSalidaResponse;
import utp.soa.avance.model.Producto;
import utp.soa.avance.model.ProductoCantidad;
import utp.soa.avance.service.ProductCantidadService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCantidadServiceImpl implements ProductCantidadService {

    @Autowired
    private ProductoCantidadRepository cantidadRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductoSalidaResponse> listByUuid(String uuid) {

        return cantidadRepository.findByUuid(uuid)
                .stream()
                .map(pCantidad -> {
                    Producto producto = productRepository.getReferenceById(pCantidad.getProducto().getId_producto());
                    return buildProductoSalidaResponse(pCantidad,producto);
                })
                .collect(Collectors.toList());
    }

    private ProductoSalidaResponse buildProductoSalidaResponse(ProductoCantidad productoCantidad, Producto producto) {
        return ProductoSalidaResponse.builder()
                .id_producto(producto.getId_producto())
                .cantidad(productoCantidad.getCantidad())
                .descripcion(producto.getDesc_producto())
                .build();
    }
}
