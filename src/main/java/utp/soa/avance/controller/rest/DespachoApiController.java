package utp.soa.avance.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.DespachoResponse;
import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.dto.TransportistaRequest;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.SalidaProducto;
import utp.soa.avance.model.Transportista;
import utp.soa.avance.service.DespachoService;
import utp.soa.avance.service.SalidaService;

import java.util.List;

@RestController
@RequestMapping("/api/gestion-despacho")
public class DespachoApiController {

    @Autowired
    private DespachoService despachoService;

    @GetMapping("")
    @Operation(summary = "Listar los Despachos planificados con la sede de Calimod")
    public ResponseEntity<List<Despacho>> mostrarDespachos(@RequestParam(defaultValue = "1") int pagina,
                                                         @RequestParam(defaultValue = "5") int tamanio) {
        return ResponseEntity.ok(despachoService.listarDespachos(pagina,tamanio).stream().toList());
    }

    @PostMapping("")
    @Operation(summary = "Crear un registro de despacho de productos")
    public ResponseEntity<DespachoResponse> crearDespacho(@RequestBody FormularioStockDTO formularioStockDTO) {
        Despacho despacho = despachoService.descontarStock(formularioStockDTO);
        return ResponseEntity.ok(DespachoResponse.builder()
                        .id(despacho.getId())
                        .sedes(despacho.getSedes().getNombre())
                        .estado(despacho.isEstado())
                        .uuid(despacho.getUuid())
                .build());
    }
}
