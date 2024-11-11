package lucacampion.gestioneViaggiAziendali.services;

import lucacampion.gestioneViaggiAziendali.entities.Viaggio;
import lucacampion.gestioneViaggiAziendali.exceptions.BadRequestException;
import lucacampion.gestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {
    @Autowired
    ViaggioRepository viaggioRepository;


    // save
    public Viaggio save(Viaggio body) {
        viaggioRepository.findByDestinazione(body.getDestinazione()).ifPresent(viaggio -> {
            throw new BadRequestException("Il viaggio verso " + body.getDestinazione() + " è già in programma");
        });
        return viaggioRepository.save(body);
    }

    // get
    public Page<Viaggio> getViaggi(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return viaggioRepository.findAll(pageable);
    }

    // find by ID
    public Viaggio findById(int id) {
        return viaggioRepository.findById(id).orElseThrow(() -> new BadRequestException("L'id non è stato trovato"));
    }

    // find by ID and UPLOAD
    public Viaggio findByIdAndUpdate(int id, Viaggio body) {
        Viaggio found = this.findById(id);
        found.setData(body.getData());
        found.setStato(body.getStato());
        found.setDestinazione(body.getDestinazione());
        return viaggioRepository.save(found);
    }

    // find by ID and DELETE
    public void findByIdAndDelete(int id) {
        Viaggio found = this.findById(id);
        viaggioRepository.delete(found);
    }
}
