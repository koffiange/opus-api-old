package ci.siracide.pole.opus.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class OffreService extends BaseEntity{
    public String titre;
    public String description;
    public BigDecimal remuneration;
    public LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID ")
    public Utilisateur utilisateur;

    public OffreService() {
    }
}
