package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.TransportistaRepository;
import utp.soa.avance.model.Transportista;
import utp.soa.avance.service.TransportistaService;

import java.util.List;
import java.util.Optional;

@Service
public class TransportistaServiceImpl implements TransportistaService {

    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public List<Transportista> listTransportistas() {
        return transportistaRepository.findAll();
    }

    @Override
    public Transportista crearTransportista(String nombre) {
        return transportistaRepository.save(Transportista.builder().nombre(nombre).disponible(true).build());
    }

    @Override
    public Transportista actualizarTransportista(Long id, String nombre) {
        Optional<Transportista> t = transportistaRepository.findById(id);

        if (t.isPresent()) {
            Transportista transportista = t.get();
            transportista.setNombre(nombre);
            return transportistaRepository.save(transportista);
        } else {
            return new Transportista();
        }
    }

    @Override
    public Transportista desactivarTransportista(Long id) {
        Optional<Transportista> t = transportistaRepository.findById(id);

        if (t.isPresent()) {
            Transportista transportista = t.get();
            transportista.setDisponible(false);
            return transportistaRepository.save(transportista);
        } else {
            return new Transportista();
        }
    }

    @Override
    public Transportista getTransportista(Long id) {
        return transportistaRepository.getReferenceById(id);
    }
}
