package utp.soa.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.soa.avance.dto.FormularioStockDTO;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.service.DespachoService;
import utp.soa.avance.service.ProductService;
import utp.soa.avance.service.SedesService;

import java.util.UUID;

@Controller
@RequestMapping("/admin/gestion-despacho")
public class DespachoController {

    @Autowired
    private SedesService sedesService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DespachoService despachoService;

    @GetMapping("/crearDespacho")
    public String mostrarFormulario(Model model) {
        Despacho despacho = Despacho.builder().uuid(UUID.randomUUID().toString()).build();

        model.addAttribute("despacho", despacho);
        model.addAttribute("sedes", sedesService.listSedes());
        model.addAttribute("productos", productService.listAll());
        return "mainDespacho";
    }

    @PostMapping("/descontar-stock/{uuid}")
    public String descontarStock(@PathVariable String uuid,@ModelAttribute FormularioStockDTO formularioStockDTO) {
        despachoService.descontarStock(formularioStockDTO);
        return "redirect:/helper/gestion-productos";
    }
}
