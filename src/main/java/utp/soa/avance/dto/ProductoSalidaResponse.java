package utp.soa.avance.dto;

import lombok.*;
import utp.soa.avance.model.Producto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoSalidaResponse {

    private Long id_producto;
    private String descripcion;
    private int cantidad;
}
