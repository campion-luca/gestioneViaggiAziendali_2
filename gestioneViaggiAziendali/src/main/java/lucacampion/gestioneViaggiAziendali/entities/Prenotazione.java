package lucacampion.gestioneViaggiAziendali.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name="prenotazioni")

@Getter
@Setter
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne // collegamento con il viaggio
    @JoinColumn(name="viaggioId")
    private Viaggio viaggio;

    @OneToOne // collegamento col dipendente
    @JoinColumn(name="dipendenteId")
    private Dipendente dipendente;

    private LocalDate dataRichiesta = LocalDate.now();
    private String noteAggiuntive;
}
