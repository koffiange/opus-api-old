package ci.siracide.pole.opus.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class ExperiencePro extends BaseEntity{
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public String entreprise;
    public String domaine;
    public String fonction;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    public ExperiencePro() {
    }
}
