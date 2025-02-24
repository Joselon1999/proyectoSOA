package utp.soa.avance.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.FormularioSalidaDTO;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.SalidaProducto;
import utp.soa.avance.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestion-salida")
public class SalidaApiController {

    @Autowired
    private DespachoService despachoService;

    @Autowired
    private SalidaService salidaService;


    @GetMapping("")
    public ResponseEntity<List<SalidaProducto>> mostrarSalidas(@RequestParam(defaultValue = "1") int pagina,
                                                               @RequestParam(defaultValue = "5") int tamanio) {
        return ResponseEntity.ok(salidaService.listarSalidas(pagina,tamanio));
    }
}
