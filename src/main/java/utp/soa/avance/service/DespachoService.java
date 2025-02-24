package utp.soa.avance.service;

import org.springframework.data.domain.Page;
import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.dto.ProductoCantidadDTO;
import utp.soa.avance.model.Despacho;

import java.util.List;

public interface DespachoService {

    Despacho descontarStock(FormularioStockDTO formularioStockDTO);
    Page<Despacho> listarDespachos(int pagina, int tamanio);

    Despacho findDespacho(String Uuid);
}
