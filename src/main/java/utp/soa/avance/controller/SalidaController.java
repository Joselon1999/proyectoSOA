package utp.soa.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.FormularioSalidaDTO;
import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.service.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/gestion-salida")
public class SalidaController {

    @Autowired
    private SedesService sedesService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DespachoService despachoService;

    @Autowired
    private ProductCantidadService productCantidadService;

    @Autowired
    private TransportistaService transportistaService;

    @Autowired
    private SalidaService salidaService;


    @GetMapping("")
    public String mostrarFormulario(@RequestParam(defaultValue = "1") int pagina,
                                    @RequestParam(defaultValue = "5") int tamanio,
                                    Model model) {
        Page<Despacho> despachos = despachoService.listarDespachos(pagina, tamanio);

        model.addAttribute("despachos", despachos.getContent());
        model.addAttribute("paginaActual", pagina);
        model.addAttribute("totalPaginas", despachos.getTotalPages());
        return "mainSalida";
    }

    @GetMapping("/enviarSede/{uuid}")
    public String mostrarFormulario(@PathVariable String uuid,Model model) {
        Despacho despacho = despachoService.findDespacho(uuid);

        FormularioSalidaDTO dto = new FormularioSalidaDTO();
        dto.setDespacho(despacho);

        model.addAttribute("salida",dto);
        model.addAttribute("despacho", despacho);
        model.addAttribute("sede", sedesService.getSede(despacho.getSedes().getId_sedes()));
        model.addAttribute("productos", productCantidadService.listByUuid(uuid));
        model.addAttribute("transportistas",transportistaService.listTransportistas());
        return "salidaProducto";
    }

    @PostMapping("/enviarSede")
    public String descontarStock(@ModelAttribute FormularioSalidaDTO formularioStockDTO) {
        salidaService.guardarRegistro(formularioStockDTO);
        return "redirect:/admin/gestion-salida";
    }
}
