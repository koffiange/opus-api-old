package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Business;
import ci.siracide.pole.opus.domain.Competence;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BusinessService implements PanacheRepositoryBase<Business, String> {

    public List<Business> listByUtilisateur(String utilisateurUuid){
        return find("utilisateur.uuid", utilisateurUuid).list();
    }

    public void persistMany(List<Business> businessList, Utilisateur utilisateur){
        businessList.forEach(business -> persistByUtilisateur(business, utilisateur));
    }

    public void persistByUtilisateur(Business business, Utilisateur utilisateur){
        business.utilisateur = utilisateur;
        business.persist();
    }

    public void update(Business business){
        Business old = Business.findById(business.uuid);
        if (old != null){
            old.libelle = business.libelle;
            old.description = business.description;
            old.adresse = business.adresse;
            old.email = business.email;
            old.contactPrincipal = business.contactPrincipal;
            old.contactSecondaire = business.contactSecondaire;
            old.domaine = business.domaine;
            old.logo = business.logo;
            old.facebook = business.facebook;
            old.instagram = business.instagram;
            old.twitter = business.twitter;
            old.siteweb = business.siteweb;
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
