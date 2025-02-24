package utp.soa.avance.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class FormularioStockDTO {
    private String uuid;
    private List<ProductoCantidadDTO> productos;
    private Long sede;
}
