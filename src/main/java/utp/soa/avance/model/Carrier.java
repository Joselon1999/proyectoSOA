package utp.soa.avance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table (name = "transportista")
@Getter
@Setter
@NoArgsConstructor

public class Carrier {

    @Id
    @GeneratedValue (strategy = IDENTITY)
    private long id_transportista;
    private String name;
}
