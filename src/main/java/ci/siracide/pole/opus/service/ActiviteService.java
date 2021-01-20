package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Activite;
import ci.siracide.pole.opus.domain.Competence;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ActiviteService implements PanacheRepositoryBase<Activite, String> {
    public List<Activite> listByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid, Sort.descending("createdDate")).list();
    }

    public void persistMany(List<Activite> activiteList, Utilisateur utilisateur){
        activiteList.forEach(activite -> persistByUtilisateur(activite, utilisateur));
    }

    public void persistByUtilisateur(Activite activite, Utilisateur utilisateur){
        activite.utilisateur = utilisateur;
        activite.persist();
    }

    public void update(Activite activite){
        Activite old = Activite.findById(activite.uuid);
        if (old != null){
            old.libelle = activite.libelle;
            old.description = activite.description;
            old.date = activite.date;
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
