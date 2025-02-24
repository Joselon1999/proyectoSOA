package utp.soa.avance.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SalidaRequest {

    private String uuid;
    private String transportistaId;
}
