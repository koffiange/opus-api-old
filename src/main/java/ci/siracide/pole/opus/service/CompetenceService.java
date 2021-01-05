package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Competence;
import ci.siracide.pole.opus.domain.ExperiencePro;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CompetenceService implements PanacheRepositoryBase<Competence, String> {

    public List<Competence> findByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid).list();
    }

    public void persistMany(List<Competence> competenceList, Utilisateur utilisateur){
        competenceList.forEach(competence -> persistByUtilisateur(competence, utilisateur));
    }

    public void persistByUtilisateur(Competence competence, Utilisateur utilisateur){
        competence.utilisateur = utilisateur;
        competence.persist();
    }

    public void update(Competence competence){
        Competence old = Competence.findById(competence.uuid);
        if (old != null){
            old.libelle = competence.libelle;
            old.description = competence.description;
            old.anneeExperience = competence.anneeExperience;
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
