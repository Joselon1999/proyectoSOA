package utp.soa.avance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "transportista")
@Getter
@Setter
@NoArgsConstructor
public class Transportista {


    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id_transportista;
    private String nombre;
    private boolean disponible;
}
