package lucacampion.gestioneViaggiAziendali.repository;

import lucacampion.gestioneViaggiAziendali.entities.Prenotazione;
import lucacampion.gestioneViaggiAziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
