package utp.soa.avance.service;

import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.dto.ProductoCantidadDTO;
import utp.soa.avance.model.Despacho;

import java.util.List;

public interface DespachoService {

    Despacho descontarStock(FormularioStockDTO formularioStockDTO);
}
