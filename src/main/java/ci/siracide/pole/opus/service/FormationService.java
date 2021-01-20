package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.ExperiencePro;
import ci.siracide.pole.opus.domain.Formation;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FormationService implements PanacheRepositoryBase<Formation, String> {
    public List<Formation> findByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid, Sort.descending("date")).list();
    }

    public void persistMany(List<Formation> formationList, Utilisateur utilisateur){
        formationList.forEach(formation -> persistByUtilisateur(formation, utilisateur));
    }

    public void persistByUtilisateur(Formation formation, Utilisateur utilisateur){
        formation.utilisateur = utilisateur;
        formation.persist();
    }

    public void update(Formation formation){
        Formation old = Formation.findById(formation.uuid);
        if (old != null){
            old.libelle = formation.libelle;
            old.diplome = formation.diplome;
            old.annee = formation.annee;
            old.persist();
        }
    }

    public void deleteMany(List<String> uuidList){
        uuidList.forEach(this::deleteById);
    }

    public void deleteByUtilisateur(String utilisateurUuid){
        delete("utilisateur.uuid", utilisateurUuid);
    }
}
