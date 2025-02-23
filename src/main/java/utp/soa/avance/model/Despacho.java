package utp.soa.avance.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "despacho")
@Getter
@Setter
@Builder
public class Despacho {


    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id;

    private String uuid;

    @ManyToOne
    private Sedes sedes;

    private boolean estado;
}
