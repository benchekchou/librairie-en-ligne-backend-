package hamza.patient.net.librairie_en_ligne.controller;

import hamza.patient.net.librairie_en_ligne.model.Livre;
import hamza.patient.net.librairie_en_ligne.service.LivreService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public List<Livre> getLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        return livreService.getLivreById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) {
        Livre saved = livreService.saveLivre(livre);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        Optional<Livre> existingLivre = livreService.getLivreById(id);
        if (existingLivre.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        livreService.deleteLivre(id);
        return ResponseEntity.noContent().build();
    }
}
