package utp.soa.avance.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.soa.avance.model.Categoria;
import utp.soa.avance.model.Subcategoria;
import utp.soa.avance.model.Usuario;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrearProductoRequest {

    private String desc_producto;

    private Double cantidad;

    private Long categoria;

    private Long subcategoria;
}
