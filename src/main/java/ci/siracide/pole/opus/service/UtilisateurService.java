package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.*;
import ci.siracide.pole.opus.dto.UtilisateurDto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UtilisateurService implements PanacheRepositoryBase<Utilisateur, String> {

    @Inject
    CommunauteService communauteService;

    @Inject
    MembreService membreService;

    @Inject
    ExperienceProService experienceProService;

    @Inject
    CompetenceService competenceService;

    @Inject
    ActiviteService activiteService;

    @Inject
    OffreEmploiService offreEmploiService;

    @Inject
    OffreServiceService offreServiceService;

    @Inject
    BusinessService businessService;

    public List<UtilisateurDto> listAllUtilisateurDto(){
        return listAll().stream().map(utilisateur -> this.findUtilisateurDtoById(utilisateur.uuid)).collect(Collectors.toList());
    }

    public UtilisateurDto findUtilisateurDtoById(String uuid){
        Utilisateur utilisateur = findById(uuid);
        List<ExperiencePro> experienceProList = experienceProService.findByUtilisateur(uuid);
        List<Competence> competenceList = competenceService.findByUtilisateur(uuid);
        List<Activite> activiteList = activiteService.findByUtilisateur(uuid);
        List<OffreEmploi> offreEmploiList = offreEmploiService.findByUtilisateur(uuid);
        List<OffreService> offreServiceList = offreServiceService.findByUtilisateur(uuid);
        List<Business> businessList = businessService.findByUtilisateur(uuid);

        return new UtilisateurDto(utilisateur, competenceList,
                                  experienceProList, activiteList,
                                  offreEmploiList, offreServiceList,
                                  businessList);
    }

    public void persist(Utilisateur utilisateur){
        utilisateur.persist();
    }

    public void persistUtilisateurDto(UtilisateurDto utilisateurDto){
        utilisateurDto.utilisateur.persist();
        experienceProService.persistMany(utilisateurDto.experienceProList, utilisateurDto.utilisateur);
        competenceService.persistMany(utilisateurDto.competenceList, utilisateurDto.utilisateur);
        activiteService.persistMany(utilisateurDto.activiteList, utilisateurDto.utilisateur);
        offreEmploiService.persistMany(utilisateurDto.offreEmploiList, utilisateurDto.utilisateur);
        offreServiceService.persistMany(utilisateurDto.offreServiceList, utilisateurDto.utilisateur);
        businessService.persistMany(utilisateurDto.businessList, utilisateurDto.utilisateur);
        if(utilisateurDto.communaute != null)
            membreService.persist(utilisateurDto.utilisateur, utilisateurDto.communaute);
    }

    public void deleteUtilisateurDto(String uuid){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        experienceProService.deleteByUtilisateur(utilisateur);
        competenceService.deleteByUtilisateur(utilisateur);
        activiteService.deleteByUtilisateur(utilisateur);
        offreEmploiService.deleteByUtilisateur(utilisateur);
        offreServiceService.deleteByUtilisateur(utilisateur);
        businessService.deleteByUtilisateur(utilisateur);
        membreService.deleteByUtilisateur(utilisateur);

        utilisateur.delete();
    }

    public void update(Utilisateur utilisateur){
        Utilisateur old = Utilisateur.findById(utilisateur.uuid);
        if(old != null){
            old.nom = utilisateur.nom;
            old.prenoms = utilisateur.prenoms;
            old.genre = utilisateur.genre;
            old.contactPrincipal = utilisateur.contactPrincipal;
            old.contactSecondaire = utilisateur.contactSecondaire;
            old.dateNaissance = utilisateur.dateNaissance;
            old.email = utilisateur.email;
            old.motDePasse = utilisateur.motDePasse;
            old.photoProfil = utilisateur.photoProfil;
            old.curriculumVitae = utilisateur.curriculumVitae;
            old.estEnQueteEmploi = utilisateur.estEnQueteEmploi;
            old.estEnPoste = utilisateur.estEnPoste;
            old.estEntrepreneur = utilisateur.estEntrepreneur;
            old.metier = utilisateur.metier;
            old.descriptionMetier = utilisateur.descriptionMetier;
            old.employeur = utilisateur.employeur;
            old.motsCles = utilisateur.motsCles;
        }
        utilisateur.persist();
    }
}
