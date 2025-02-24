package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.DespachoRepository;
import utp.soa.avance.dao.ProductRepository;
import utp.soa.avance.dao.ProductoCantidadRepository;
import utp.soa.avance.dao.SedesRepository;
import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.dto.ProductoCantidadDTO;
import utp.soa.avance.model.*;
import utp.soa.avance.service.DespachoService;

import java.util.List;

@Service
public class DespachoServiceImpl implements DespachoService {

    @Autowired
    private SedesRepository sedesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductoCantidadRepository cantidadRepository;

    @Autowired
    private DespachoRepository despachoRepository;

    @Override
    public Despacho descontarStock(FormularioStockDTO formularioStockDTO) {

        for (ProductoCantidadDTO formulario : formularioStockDTO.getProductos()) {
            if (formulario.getCantidad() > 0) {
                Producto producto = productRepository.findById(formulario.getId())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
                producto.setCantidad(producto.getCantidad() - formulario.getCantidad());
                productRepository.save(producto);

                cantidadRepository.save(buildProductoCantidad(producto,formulario.getCantidad(), formularioStockDTO.getUuid()));
            }
        }
        Sedes sede = sedesRepository.getReferenceById(formularioStockDTO.getSede());
        Despacho despacho = Despacho.builder()
                .sedes(sede)
                .uuid(formularioStockDTO.getUuid())
                .estado(true)
                .build();

        return despachoRepository.save(despacho);
    }

    @Override
    public Page<Despacho> listarDespachos(int pagina, int tamanio) {
        return despachoRepository.findAll(PageRequest.of(pagina-1,tamanio));
    }

    @Override
    public Despacho findDespacho(String uuid) {
        return despachoRepository.findByUuid(uuid).orElse(Despacho.builder().build());
    }

    private ProductoCantidad buildProductoCantidad(Producto producto, int cantidad, String uuid) {
        return ProductoCantidad.builder()
                .producto(producto)
                .cantidad(cantidad)
                .uuid(uuid)
                .build();
    }
}
