package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Communaute;
import ci.siracide.pole.opus.domain.Membre;
import ci.siracide.pole.opus.domain.Utilisateur;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MembreService implements PanacheRepositoryBase<Membre,String> {

    public void persist(Utilisateur utilisateur, Communaute communaute){
        Membre membre = new Membre(utilisateur, communaute);
        persist(membre);
    }

    public List<Membre> findByCommunaute(Communaute communaute){
        return list("communaute.uuid", communaute.uuid);
    }

    public List<Membre> findByUtilisateur(Utilisateur utilisateur){
        return list("utilisateur.uuid", utilisateur.uuid);
    }

    public void deleteByCommunaute(Communaute communaute){
        delete("communaute.uuid", communaute.uuid);
    }

    public void deleteByUtilisateur(String uuid){
        delete("utilisateur.uuid", uuid);
    }
}
