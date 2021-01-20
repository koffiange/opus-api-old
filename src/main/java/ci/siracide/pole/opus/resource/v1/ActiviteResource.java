package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.Activite;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.ActiviteService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/activites")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ActiviteResource {
    @Inject
    ActiviteService activiteService;

    @GET
    public List<Activite> listAll(){
        return activiteService.listAll();
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public Activite findById(@PathParam("uuid") String uuid){
        return activiteService.findById(uuid);
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public List<Activite> listByUtilisateur(@PathParam("uuid") String uuid){
        return activiteService.listByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, Activite activite){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        activiteService.persistByUtilisateur(activite, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistManyByUtilisateur(@PathParam("uuid") String uuid, List<Activite> activiteList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        activiteService.persistMany(activiteList, utilisateur);
    }

    @PUT
    public void update(Activite competence){
        activiteService.update(competence);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        activiteService.deleteByUtilisateur(uuid);
    }
}
