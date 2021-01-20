package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.Business;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.BusinessService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/entreprises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class BusinessResource {
    @Inject
    BusinessService businessService;

    @GET
    public List<Business> listAll(){
        return businessService.listAll();
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public Business findById(@PathParam("uuid") String uuid){
        return businessService.findById(uuid);
    }

    @GET
    @Path("/utilisateur/{uuid}")
    public List<Business> listByUtilisateur(@PathParam("uuid") String uuid){
        return businessService.listByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, Business business){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        businessService.persistByUtilisateur(business, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistManyByUtilisateur(@PathParam("uuid") String uuid, List<Business> businessList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        businessService.persistMany(businessList, utilisateur);
    }

    @PUT
    public void update(Business business){
        businessService.update(business);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        businessService.deleteByUtilisateur(uuid);
    }
}
