package ci.siracide.pole.opus.resource;

import ci.siracide.pole.opus.domain.ExperiencePro;
import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.service.ExperienceProService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/experiences-pro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ExperienceProResource {
    @Inject
    ExperienceProService experienceProService;

    @GET
    @Path("/utilisateur/{uuid}")
    public List<ExperiencePro> listByUtilisateur(@PathParam("uuid") String uuid){
        return experienceProService.findByUtilisateur(uuid);
    }

    @POST
    @Path("/utilisateur/{uuid}")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, ExperiencePro experiencePro){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        experienceProService.persistByUtilisateur(experiencePro, utilisateur);
    }

    @POST
    @Path("/utilisateur/{uuid}/many")
    public void persistByUtilisateur(@PathParam("uuid") String uuid, List<ExperiencePro> experienceProList){
        Utilisateur utilisateur = Utilisateur.findById(uuid);
        experienceProService.persistMany(experienceProList, utilisateur);
    }

    @DELETE
    @Path("/utilisateur/{uuid}")
    public void deleteByUtilisateur(@PathParam("uuid") String uuid){
        experienceProService.deleteByUtilisateur(uuid);
    }

    @DELETE
    @Path("/many")
    public void deleteByUtilisateur(List<String> uuidList){
        experienceProService.deleteMany(uuidList);
    }

    @DELETE
    @Path("/{uuid}")
    public void delete(@PathParam("uuid") String uuid){
        experienceProService.deleteById(uuid);
    }

}
