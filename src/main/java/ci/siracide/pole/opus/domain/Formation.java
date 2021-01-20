package ci.siracide.pole.opus.domain;

import ci.siracide.pole.opus.enumeration.Diplome;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation extends BaseEntity{
    public String libelle;
    public Diplome diplome;
    public Integer annee;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    public Formation() {
    }
}
