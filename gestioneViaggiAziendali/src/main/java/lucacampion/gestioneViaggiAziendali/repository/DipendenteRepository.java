package lucacampion.gestioneViaggiAziendali.repository;

import lucacampion.gestioneViaggiAziendali.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    Optional<Dipendente> findByEmail(String email);
}
