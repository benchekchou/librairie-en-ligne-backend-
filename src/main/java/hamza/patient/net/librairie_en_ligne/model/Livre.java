package hamza.patient.net.librairie_en_ligne.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titre;

    @Column(nullable = false, length = 100)
    private String auteur;

    @Column(name = "date_publication", nullable = false)
    private LocalDate date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    protected Livre() {
        // Constructor required by JPA
    }

    public Livre(String titre, String auteur, LocalDate date, BigDecimal prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.date = date;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
