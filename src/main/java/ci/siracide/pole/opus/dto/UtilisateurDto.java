package ci.siracide.pole.opus.dto;

import ci.siracide.pole.opus.domain.*;

import java.util.List;

public class UtilisateurDto {
    public Utilisateur utilisateur;
    public Communaute communaute;
    public List<Formation> formationList;
    public List<Competence> competenceList;
    public List<ExperiencePro> experienceProList;
    public List<Activite> activiteList;
    public List<OffreEmploi> offreEmploiList;
    public List<OffreService> offreServiceList;
    public List<Business> businessList;

    public UtilisateurDto(Utilisateur utilisateur, List<Competence> competenceList,
                          List<ExperiencePro> experienceProList, List<Activite> activiteList,
                          List<OffreEmploi> offreEmploiList, List<OffreService> offreServiceList,
                          List<Business> businessList) {
        this.utilisateur = utilisateur;
        this.competenceList = competenceList;
        this.experienceProList = experienceProList;
        this.activiteList = activiteList;
        this.offreEmploiList = offreEmploiList;
        this.offreServiceList = offreServiceList;
        this.businessList = businessList;
    }

    public UtilisateurDto() {
    }
}
