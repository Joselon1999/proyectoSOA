package utp.soa.avance.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "salidaproducto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalidaProducto {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;

    @ManyToOne
    private Transportista transportista;

    @ManyToOne
    private Despacho despacho;
}
