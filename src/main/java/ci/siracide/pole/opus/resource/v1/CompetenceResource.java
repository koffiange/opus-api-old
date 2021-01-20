package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.Competence;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.CompetenceService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/competences")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class CompetenceResource {
    @Inject
    CompetenceService competenceService;

    @GET
    public List<Competence> listAll(){
        return competenceService.listAll();
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public Competence findById(@PathParam("uuid") String uuid){
        return competenceService.findById(uuid);
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public List<Competence> listByUtilisateur(@PathParam("uuid") String uuid){
        return competenceService.listByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, Competence competence){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        competenceService.persistByUtilisateur(competence, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistManyByUtilisateur(@PathParam("uuid") String uuid, List<Competence> competenceList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        competenceService.persistMany(competenceList, utilisateur);
    }

    @PUT
    public void update(Competence competence){
        competenceService.update(competence);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        competenceService.deleteByUtilisateur(uuid);
    }
}
