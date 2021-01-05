package ci.siracide.pole.opus.domain;

import ci.siracide.pole.opus.enumeration.TypeCommunaute;

import javax.persistence.Entity;

@Entity
public class Communaute extends BaseEntity{
    public String libelle;
    public String description;
    public String logo;
    public String contactPrincipal;
    public String contactSecondaire;
    public String adresse;
    public String email;
    public TypeCommunaute typeCommunaute;
    public String siteweb;
    public String facebook;
    public String instagram;
    public String twitter;

    public Communaute() {
    }
}
