package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.OffreEmploi;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.OffreEmploiService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/offres-emploi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OffreEmploiResource {
    @Inject
    OffreEmploiService offreEmploiService;

    @GET
    public List<OffreEmploi> listAll(){
        return offreEmploiService.listAll();
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public OffreEmploi findById(@PathParam("uuid") String uuid){
        return offreEmploiService.findById(uuid);
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public List<OffreEmploi> listByUtilisateur(@PathParam("uuid") String uuid){
        return offreEmploiService.listByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, OffreEmploi offreEmploi){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        offreEmploiService.persistByUtilisateur(offreEmploi, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistManyByUtilisateur(@PathParam("uuid") String uuid, List<OffreEmploi> offreEmploiList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        offreEmploiService.persistMany(offreEmploiList, utilisateur);
    }

    @PUT
    public void update(OffreEmploi offreEmploi){
        offreEmploiService.update(offreEmploi);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        offreEmploiService.deleteByUtilisateur(uuid);
    }
}
