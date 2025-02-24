package utp.soa.avance.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.PutTransportistaRequest;
import utp.soa.avance.model.SalidaProducto;
import utp.soa.avance.model.Transportista;
import utp.soa.avance.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion-salida")
public class SalidaApiController {

    @Autowired
    private DespachoService despachoService;

    @Autowired
    private SalidaService salidaService;


    @Autowired
    private TransportistaService transportistaService;



    @GetMapping("")
    @Operation(summary = "Listar las salidas de productos a las sedes de Calimod")
    public ResponseEntity<List<SalidaProducto>> mostrarSalidas(@RequestParam(defaultValue = "1") int pagina,
                                                               @RequestParam(defaultValue = "5") int tamanio) {
        return ResponseEntity.ok(salidaService.listarSalidas(pagina,tamanio));
    }

    @GetMapping("/transportistas")
    @Operation(summary = "Listar todos los transportistas")
    public ResponseEntity<List<Transportista>> mostrarTransportistas() {
        return ResponseEntity.ok(transportistaService.listTransportistas());
    }

    @PutMapping("/transportistas/{id}")
    @Operation(summary = "Actualizar un transportista")
    public ResponseEntity<Transportista> actualizarTransportista(@PathVariable("id") Long id,
                                                                 PutTransportistaRequest request) {
        return ResponseEntity.ok(transportistaService.actualizarTransportista(id,request.getNombre()));
    }

    @Operation(summary = "Descativar un transportista")
    @PatchMapping("/transportistas/{id}")
    public ResponseEntity<Transportista> desactivarTransportista(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transportistaService.desactivarTransportista(id));
    }
}
