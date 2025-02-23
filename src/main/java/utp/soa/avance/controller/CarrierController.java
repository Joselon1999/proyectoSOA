package utp.soa.avance.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.soa.avance.dao.CarrierRepository;
import utp.soa.avance.model.Carrier;
import utp.soa.avance.service.CarrierService;

@Controller
@RequestMapping("transportista")

public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    @Autowired
    private CarrierRepository carrierRepository;

    @GetMapping
    public String MostrarTransportista (Model model){
        carrierService.ListarTransportista();
        model.addText("name");
        return "";
    }
}
