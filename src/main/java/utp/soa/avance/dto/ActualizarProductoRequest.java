package utp.soa.avance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarProductoRequest {

    private Long id;

    private String desc_producto;

    private Double cantidad;

    private Long categoria;

    private Long subcategoria;
}
