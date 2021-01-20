package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.OffreEmploi;
import ci.siracide.pole.opus.domain.OffreService;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OffreServiceService implements PanacheRepositoryBase<OffreService, String> {

    public List<OffreService> listByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid, Sort.descending("createdDate")).list();
    }

    public void persistMany(List<OffreService> offreServiceList, Utilisateur utilisateur){
        offreServiceList.forEach(offreService -> persistByUtilisateur(offreService, utilisateur));
    }

    public void persistByUtilisateur(OffreService offreService, Utilisateur utilisateur){
        offreService.utilisateur = utilisateur;
        offreService.persist();
    }

    public void update(OffreService offreService){
        OffreService old = OffreService.findById(offreService.uuid);
        if (old != null){
            old.titre = offreService.titre;
            old.description = offreService.description;
            old.remuneration = offreService.remuneration;
            old.dateExpiration = offreService.dateExpiration;
            old.persist();
        }
    }

    public void deleteMany(List<String> uuidList){
        uuidList.forEach(this::deleteById);
    }

    public void deleteByUtilisateur(String uuid){
        delete("utilisateur.uuid", uuid);
    }
}
