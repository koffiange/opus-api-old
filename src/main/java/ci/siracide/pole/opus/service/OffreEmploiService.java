package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Activite;
import ci.siracide.pole.opus.domain.OffreEmploi;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OffreEmploiService implements PanacheRepositoryBase<OffreEmploi, String> {

    public List<OffreEmploi> findByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid, Sort.descending("createdDate")).list();
    }

    public void persistMany(List<OffreEmploi> offreEmploiList, Utilisateur utilisateur){
        offreEmploiList.forEach(offreEmploi -> persistByUtilisateur(offreEmploi, utilisateur));
    }

    public void persistByUtilisateur(OffreEmploi offreEmploi, Utilisateur utilisateur){
        offreEmploi.utilisateur = utilisateur;
        offreEmploi.persist();
    }

    public void update(OffreEmploi offreEmploi){
        OffreEmploi old = OffreEmploi.findById(offreEmploi.uuid);
        if (old != null){
            old.titre = offreEmploi.titre;
            old.description = offreEmploi.description;
            old.remuneration = offreEmploi.remuneration;
            old.entreprise = offreEmploi.entreprise;
            old.dateExpiration = offreEmploi.dateExpiration;
            old.persist();
        }
    }

    public void deleteMany(List<String> uuidList){
        uuidList.forEach(this::deleteById);
    }

    public void deleteByUtilisateur(Utilisateur utilisateur){
        delete("utilisateur.uuid", utilisateur.uuid);
    }
}
