package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.OffreService;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.OffreServiceService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/offres-service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OffreServiceResource {
    @Inject
    OffreServiceService offreServiceService;

    @GET
    public List<OffreService> listAll(){
        return offreServiceService.listAll();
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public OffreService findById(@PathParam("uuid") String uuid){
        return offreServiceService.findById(uuid);
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public List<OffreService> listByUtilisateur(@PathParam("uuid") String uuid){
        return offreServiceService.listByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, OffreService offreService){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        offreServiceService.persistByUtilisateur(offreService, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistManyByUtilisateur(@PathParam("uuid") String uuid, List<OffreService> offreServiceList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        offreServiceService.persistMany(offreServiceList, utilisateur);
    }

    @PUT
    public void update(OffreService offreService){
        offreServiceService.update(offreService);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        offreServiceService.deleteByUtilisateur(uuid);
    }
}
