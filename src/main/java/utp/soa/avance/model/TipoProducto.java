package utp.soa.avance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tipoproducto")
@Getter
@Setter
@NoArgsConstructor
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;

    @Column(name = "nom_categoria")
    private String nombre;

    private boolean estado;
}
