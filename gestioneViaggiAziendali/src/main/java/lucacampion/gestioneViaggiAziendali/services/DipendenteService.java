package lucacampion.gestioneViaggiAziendali.services;

import lucacampion.gestioneViaggiAziendali.entities.Dipendente;
import lucacampion.gestioneViaggiAziendali.exceptions.BadRequestException;
import lucacampion.gestioneViaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {
    @Autowired
    DipendenteRepository dipendenteRepository;

    // save
    public Dipendente save(Dipendente body) {
        dipendenteRepository.findByEmail(body.getEmail()).ifPresent(dipendente -> {
            throw new BadRequestException("l'email " + body.getEmail() + " è già stata utilizzata");
        });
        return dipendenteRepository.save(body);
    }

    // get
    public Page<Dipendente> getDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteRepository.findAll(pageable);
    }

    // find by ID
    public Dipendente findById(int id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new BadRequestException("L'id non è stato trovato"));
    }

    // find by ID and UPLOAD
    public Dipendente findByIdAndUpdate(int id, Dipendente body) {
        Dipendente found = this.findById(id);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setUsername(body.getUsername());
        found.setViaggio(body.getViaggio());
        return dipendenteRepository.save(found);
    }

    // find by ID and DELETE
    public void findByIdAndDelete(int id) {
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }
}
