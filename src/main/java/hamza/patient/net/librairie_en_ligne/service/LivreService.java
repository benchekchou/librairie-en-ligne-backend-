package hamza.patient.net.librairie_en_ligne.service;

import hamza.patient.net.librairie_en_ligne.model.Livre;
import hamza.patient.net.librairie_en_ligne.repository.LivreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
