package utp.soa.avance.dto;

import lombok.*;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.Transportista;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormularioSalidaDTO {
    private Despacho despacho;
    private Transportista transportista;
}
