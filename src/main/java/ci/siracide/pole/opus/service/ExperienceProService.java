package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.ExperiencePro;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ExperienceProService implements PanacheRepositoryBase<ExperiencePro, String>{
    public List<ExperiencePro> findByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid, Sort.descending("dateDebut")).list();
    }

    public void persistMany(List<ExperiencePro> experienceProList, Utilisateur utilisateur){
        experienceProList.forEach(experiencePro -> persistByUtilisateur(experiencePro, utilisateur));
    }

    public void persistByUtilisateur(ExperiencePro experiencePro, Utilisateur utilisateur){
        experiencePro.utilisateur = utilisateur;
        experiencePro.persist();
    }

    public void update(ExperiencePro experiencePro){
        ExperiencePro old = ExperiencePro.findById(experiencePro.uuid);
        if (old != null){
            old.dateDebut = experiencePro.dateDebut;
            old.dateFin = experiencePro.dateFin;
            old.domaine = experiencePro.domaine;
            old.entreprise = experiencePro.entreprise;
            old.fonction = experiencePro.fonction;
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
