package ci.siracide.pole.opus.domain;

import ci.siracide.pole.opus.enumeration.RoleCommunautaire;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Membre extends BaseEntity{
    public LocalDate dateAdhesion;
    public RoleCommunautaire role;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "COMMUNAUTE_ID ")
    public Communaute communaute;

    public Membre() {
    }

    public Membre(Utilisateur utilisateur, Communaute communaute) {
        this.dateAdhesion = LocalDate.now();
        this.role = RoleCommunautaire.PARTICIPANT;
        this.utilisateur = utilisateur;
        this.communaute = communaute;
    }
}
