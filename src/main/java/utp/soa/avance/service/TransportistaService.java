package utp.soa.avance.service;

import utp.soa.avance.model.Transportista;

import java.util.List;

public interface TransportistaService {

    Transportista crearTransportista(String nombre);
    List<Transportista> listTransportistas();

    Transportista actualizarTransportista(Long id,String nombre);
    Transportista desactivarTransportista(Long id);
}
