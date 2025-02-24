package utp.soa.avance.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.SalidaProducto;
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
}
