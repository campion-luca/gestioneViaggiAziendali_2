package lucacampion.gestioneViaggiAziendali.repository;

import lucacampion.gestioneViaggiAziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {
    Optional<Viaggio> findByDestinazione(String destinazione);
}
