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
@Table(name = "sedes")
@Getter
@Setter
@NoArgsConstructor
public class Sedes {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Long id_sedes;
    private String nombre;
    private String direccion;
}
