package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.TransportistaRepository;
import utp.soa.avance.model.Transportista;
import utp.soa.avance.service.TransportistaService;

import java.util.List;

@Service
public class TransportistaServiceImpl implements TransportistaService {

    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public List<Transportista> listTransportistas() {
        return transportistaRepository.findAll();
    }
}
