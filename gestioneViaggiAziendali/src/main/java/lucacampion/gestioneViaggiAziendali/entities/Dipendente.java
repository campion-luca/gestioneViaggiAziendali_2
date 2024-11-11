package lucacampion.gestioneViaggiAziendali.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="dipendenti")

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @OneToOne
    @JoinColumn(name="viaggioId")
    private Viaggio viaggio;


    // costruttore
    public Dipendente(String cognome, String email, String nome, String username) {
        this.cognome = cognome;
        this.email = email;
        this.nome = nome;
        this.username = username;
    }
}
