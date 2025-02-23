package utp.soa.avance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id_producto;

    private String desc_producto;

    @PositiveOrZero(message = "La cantidad debe ser un número positivo")
    private Double cantidad;

    private LocalDate fecha_ingreso;

    private String estado_producto;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Subcategoria subcategoria;
}
