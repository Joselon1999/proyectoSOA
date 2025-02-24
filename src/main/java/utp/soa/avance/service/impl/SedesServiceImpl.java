package utp.soa.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.soa.avance.dao.SedesRepository;
import utp.soa.avance.model.Sedes;
import utp.soa.avance.service.SedesService;

import java.util.List;

@Service
public class SedesServiceImpl implements SedesService {

    @Autowired
    private SedesRepository sedesRepository;

    @Override
    public List<Sedes> listSedes() {
        return sedesRepository.findAll();
    }

    @Override
    public Sedes getSede(Long id) {
        return sedesRepository.getReferenceById(id);
    }
}
