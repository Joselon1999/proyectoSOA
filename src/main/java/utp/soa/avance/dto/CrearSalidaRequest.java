package utp.soa.avance.dto;

import lombok.*;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.Transportista;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrearSalidaRequest {
    private String despacho;
    private Long transportista;
}
