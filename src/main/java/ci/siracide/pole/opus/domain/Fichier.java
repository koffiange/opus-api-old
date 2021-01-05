package ci.siracide.pole.opus.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Fichier extends BaseEntity{
    public String nom;
    public String repertoire;
    public String extesion;
    @Lob
    public String contenu;

    @ManyToOne
    @JoinColumn(name = "ACTIVITE_ID")
    public Activite activite;

    @ManyToOne
    @JoinColumn(name = "OFFRE_EMPLOI_ID")
    public OffreEmploi offreEmploi;

    public Fichier() {
    }
}
