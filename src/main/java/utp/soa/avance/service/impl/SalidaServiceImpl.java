package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.DespachoRepository;
import utp.soa.avance.dao.ProductoCantidadRepository;
import utp.soa.avance.dao.SalidaProductoRepository;
import utp.soa.avance.dao.TransportistaRepository;
import utp.soa.avance.dto.FormularioSalidaDTO;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.ProductoCantidad;
import utp.soa.avance.model.SalidaProducto;
import utp.soa.avance.model.Transportista;
import utp.soa.avance.service.SalidaService;

import java.util.List;

@Service
public class SalidaServiceImpl implements SalidaService {

    @Autowired
    private ProductoCantidadRepository cantidadRepository;

    @Autowired
    private SalidaProductoRepository salidaProductoRepository;

    @Autowired
    private DespachoRepository despachoRepository;

    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public List<ProductoCantidad> findByUuid(String uuid) {
        return cantidadRepository.findByUuid(uuid);
    }

    @Override
    public SalidaProducto guardarRegistro(FormularioSalidaDTO formularioStockDTO) {
        Despacho despacho = despachoRepository.getReferenceById(formularioStockDTO.getDespacho().getId());
        Transportista transportista = transportistaRepository.getReferenceById(formularioStockDTO.getTransportista().getId_transportista());
        return salidaProductoRepository.save(
                SalidaProducto.builder()
                        .transportista(transportista)
                        .despacho(despacho)
                        .build());
    }
}
