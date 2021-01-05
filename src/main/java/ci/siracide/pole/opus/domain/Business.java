package ci.siracide.pole.opus.domain;

import ci.siracide.pole.opus.enumeration.TypeCommunaute;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Business extends BaseEntity{
    public String libelle;
    public String description;
    public String domaine;
    public String logo;
    public String contactPrincipal;
    public String contactSecondaire;
    public String adresse;
    public String email;
    public String siteweb;
    public String facebook;
    public String instagram;
    public String twitter;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    public Business() {
    }
}
