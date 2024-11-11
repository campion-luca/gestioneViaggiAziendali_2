package lucacampion.gestioneViaggiAziendali.controllers;


import lucacampion.gestioneViaggiAziendali.entities.Viaggio;
import lucacampion.gestioneViaggiAziendali.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {
    @Autowired
    ViaggioService viaggioService;

    // C R U D
    // ________________________________________________________________________________
    // 1. POST - http://localhost:3001/dipendenti + req. body
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio saveViaggio(@RequestBody Viaggio body) throws Exception {
        return viaggioService.save(body);
    }

    // 2. GET - http://localhost:3001/dipendenti
    @GetMapping("")
    public Page<Viaggio> getViaggio(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return viaggioService.getViaggi(page, size, sortBy);
    }

    // 3. GET specifico - http://localhost:3001/dipendenti/{id}
    @GetMapping("/{viaggioId}")
    public Viaggio findById(@PathVariable int viaggioId) {
        return viaggioService.findById(viaggioId);
    }

    // 4. PUT http://localhost:3001/dipendenti/{id} + req. body
    @PutMapping("/{viaggioId}")
    public Viaggio findAndUpdate(@PathVariable int viaggioId, @RequestBody Viaggio body){
        return viaggioService.findByIdAndUpdate(viaggioId, body);
    }

    // 5. DELETE http://localhost:3001/dipendenti/{id}
    @DeleteMapping("/{viaggioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int viaggioId) {
        viaggioService.findByIdAndDelete(viaggioId);
    }

}
