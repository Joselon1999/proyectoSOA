package utp.soa.avance.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Builder
@Entity
@Table(name = "productocantidad")
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCantidad {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;

    @ManyToOne
    private Producto producto;
    private String uuid;
    private int cantidad;
}
