package lucacampion.gestioneViaggiAziendali.controllers;

import lucacampion.gestioneViaggiAziendali.entities.Prenotazione;
import lucacampion.gestioneViaggiAziendali.payloads.NuovaPrenotazionePayload;
import lucacampion.gestioneViaggiAziendali.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService prenotazioneService;



    // 1. - POST http://localhost:3001/prenotazioni + req.body
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione savePrenotazione(@RequestBody NuovaPrenotazionePayload body) {
        return prenotazioneService.save(body);
    }

    // 2. - GET http://localhost:3001/blogs
    @GetMapping("")
    public List<Prenotazione> getPrenotazioni(@RequestParam(required = false) Integer dipendenteId) {
        if(dipendenteId != null) return prenotazioneService.findByDipendente(dipendenteId);
        else return prenotazioneService.getPrenotazioni();
    }
//
//    // 3. - GET http://localhost:3001/blogs/{id}
//    @GetMapping("/{blogId}")
//    public Blogpost findById(@PathVariable int blogId) {
//        return blogsService.findById(blogId);
//    }
//
//    // 4. - PUT http://localhost:3001/blogs/{id} (+ req.body)
//    @PutMapping("/{blogId}")
//    public Blogpost findAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPostPayload body) {
//        return blogsService.findByIdAndUpdate(blogId, body);
//    }
//
//    // 5. - DELETE http://localhost:3001/blogs/{id
//    @DeleteMapping("/{blogId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
//    public void findAndDelete(@PathVariable int blogId) {
//        blogsService.findByIdAndDelete(blogId);
//    }
}
