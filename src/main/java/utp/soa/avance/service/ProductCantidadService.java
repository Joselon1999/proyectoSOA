package utp.soa.avance.service;

import org.springframework.data.domain.Page;
import utp.soa.avance.dto.ProductoSalidaResponse;
import utp.soa.avance.dto.UseProductRequest;
import utp.soa.avance.model.Producto;
import utp.soa.avance.model.ProductoCantidad;

import java.util.List;
import java.util.Optional;

public interface ProductCantidadService {

    List<ProductoSalidaResponse> listByUuid(String uuid);
}
