package utp.soa.avance.service;

import utp.soa.avance.dto.FormularioSalidaDTO;
import utp.soa.avance.model.ProductoCantidad;
import utp.soa.avance.model.SalidaProducto;

import java.util.List;

public interface SalidaService {

    List<ProductoCantidad> findByUuid(String uuid);

    SalidaProducto guardarRegistro(FormularioSalidaDTO formularioStockDTO);
}
