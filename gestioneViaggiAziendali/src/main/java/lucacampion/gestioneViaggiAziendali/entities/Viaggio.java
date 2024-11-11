package lucacampion.gestioneViaggiAziendali.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="viaggi")

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String destinazione;
    private String stato;
    private LocalDate data;



    // costruttore
    public Viaggio(LocalDate data, String stato, String destinazione) {
        this.data = data;
        this.stato = stato;
        this.destinazione = destinazione;
    }
}
