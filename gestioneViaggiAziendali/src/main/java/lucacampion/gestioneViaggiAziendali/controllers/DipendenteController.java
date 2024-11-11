package lucacampion.gestioneViaggiAziendali.controllers;

import lucacampion.gestioneViaggiAziendali.entities.Dipendente;
import lucacampion.gestioneViaggiAziendali.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {
    @Autowired
    DipendenteService dipendenteService;

    // C R U D
    // ________________________________________________________________________________
    // 1. POST - http://localhost:3001/dipendenti + req. body
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody Dipendente body) throws Exception {
        return dipendenteService.save(body);
    }

    // 2. GET - http://localhost:3001/dipendenti
    @GetMapping("")
    public Page<Dipendente> getDipendente(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getDipendenti(page, size, sortBy);
    }

    // 3. GET specifico - http://localhost:3001/dipendenti/{id}
    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int dipendenteId) {
        return dipendenteService.findById(dipendenteId);
    }

    // 4. PUT http://localhost:3001/dipendenti/{id} + req. body
    @PutMapping("/{dipendenteId}")
    public Dipendente findAndUpdate(@PathVariable int dipendenteId, @RequestBody Dipendente body){
        return dipendenteService.findByIdAndUpdate(dipendenteId, body);
    }

    // 5. DELETE http://localhost:3001/dipendenti/{id}
    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int dipendenteid) {
        dipendenteService.findByIdAndDelete(dipendenteid);
    }
}
