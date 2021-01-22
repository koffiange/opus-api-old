package ci.siracide.pole.opus.domain;

import ci.siracide.pole.opus.enumeration.Genre;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Utilisateur extends BaseEntity {
    public String nom;
    public String prenoms;
    @Enumerated(EnumType.STRING)
    public Genre genre;
    public LocalDate dateNaissance;
    public String email;
    public String motDePasse;
    @Column(unique = true)
    public String contactPrincipal;
    public String contactSecondaire;
    public String adresse;
    @Lob
    public String photoProfil;
    @Lob
    public String curriculumVitae;
    public Boolean estEnQueteEmploi;
    public Boolean estEnPoste;
    public Boolean estEntrepreneur;
    public String metier;
    public String descriptionMetier;
    public String employeur;
    public String motsCles;

    public Utilisateur() {
    }
}
