package utp.soa.avance.dto;

import jakarta.persistence.*;
import lombok.*;
import utp.soa.avance.model.Despacho;
import utp.soa.avance.model.Transportista;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalidaProductoDto {

    private Long id;

    private String transportista;

    private String despacho;
}
