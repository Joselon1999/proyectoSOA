package utp.soa.avance.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import utp.soa.avance.model.Categoria;
import utp.soa.avance.model.Subcategoria;
import utp.soa.avance.model.Usuario;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrearProductoResponse {

    private Long id_producto;

    private String desc_producto;

    private Double cantidad;

    private LocalDate fecha_ingreso;

    private String estado_producto;

    private String categoria;

    private String subcategoria;
}
