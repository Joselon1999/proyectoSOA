package utp.soa.avance.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCantidadDTO {
    private Long id;
    private int cantidad;
}
