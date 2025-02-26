package utp.soa.avance.dto;

import jakarta.persistence.*;
import lombok.*;
import utp.soa.avance.model.Sedes;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DespachoResponse {

    private Long id;

    private String uuid;

    private String sedes;

    private boolean estado;
}
