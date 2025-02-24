package utp.soa.avance.service;

import utp.soa.avance.model.Sedes;

import java.util.List;

public interface SedesService {

    List<Sedes> listSedes();
    Sedes getSede(Long id);
}
