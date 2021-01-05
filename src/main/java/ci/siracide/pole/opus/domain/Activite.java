package ci.siracide.pole.opus.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Activite extends BaseEntity{
    public String libelle;
    public String description;
    public LocalDate date;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    public Activite() {
    }
}
