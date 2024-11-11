package lucacampion.gestioneViaggiAziendali.services;

import lucacampion.gestioneViaggiAziendali.entities.Dipendente;
import lucacampion.gestioneViaggiAziendali.entities.Prenotazione;
import lucacampion.gestioneViaggiAziendali.entities.Viaggio;
import lucacampion.gestioneViaggiAziendali.exceptions.NotFoundException;
import lucacampion.gestioneViaggiAziendali.payloads.NuovaPrenotazionePayload;
import lucacampion.gestioneViaggiAziendali.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    @Autowired
    DipendenteService dipendenteService;
    @Autowired
    ViaggioService viaggioService;


    // save
    public Prenotazione save(NuovaPrenotazionePayload body) {
        Dipendente dipendente = dipendenteService.findById(body.getDipendenteId());
        Viaggio viaggio = viaggioService.findById(body.getViaggioId());
        Prenotazione newPrenotazione = new Prenotazione();

        newPrenotazione.setNoteAggiuntive(body.getNoteAggiunte());
        newPrenotazione.setDipendente(dipendente);
        newPrenotazione.setViaggio(viaggio);

        return prenotazioneRepository.save(newPrenotazione);
    }

    // get all
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    // find by id
    public Prenotazione findById(int id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    // find and delete
    public void findByIdAndDelete(int id) {
        Prenotazione found = this.findById(id);
        prenotazioneRepository.delete(found);
    }

    // find and update
    public Prenotazione findByIdAndUpdate(int id, NuovaPrenotazionePayload body) {
        Prenotazione found = this.findById(id);
        Dipendente dipendente = dipendenteService.findById(body.getDipendenteId());
        Viaggio viaggio = viaggioService.findById(body.getViaggioId());

        found.setNoteAggiuntive(body.getNoteAggiunte());
        found.setDipendente(dipendente);
        found.setViaggio(viaggio);
        // manca un parametro?

        // DA RISOLVERE !!!!  _________________________________________
//        if(found.getAuthor().getId()!= body.getAuthorId()) {
//            Author newAuthor = authorsService.findById(body.getAuthorId());
//            found.setAuthor(newAuthor);
//        }
//
//        return blogsRepository.save(found);
//    }
//
//    public List<Blogpost> findByAuthor(int authorId){
//        Author author = authorsService.findById(authorId);
//        return blogsRepository.findByAuthor(author);
//    }
//}
