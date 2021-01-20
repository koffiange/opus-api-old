package ci.siracide.pole.opus.resource.v1;

import ci.siracide.pole.opus.domain.Utilisateur;
import ci.siracide.pole.opus.dto.UtilisateurDto;
import ci.siracide.pole.opus.service.UtilisateurService;
import org.junit.jupiter.api.Tag;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/utilisateurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UtilisateurResource {
    @Inject
    UtilisateurService utilisateurService;

    @GET
    public List<Utilisateur> listAll(){
        return utilisateurService.listAll();
    }

    @GET
    @Path("/dto")
    public List<UtilisateurDto> listAllUtilisateurDto(){
        return utilisateurService.listAllUtilisateurDto();
    }

    @POST
    public void persist(UtilisateurDto utilisateurDto){
        utilisateurService.persistUtilisateurDto(utilisateurDto);
    }

    @DELETE
    @Path("/dto/{uuid}")
    public void delete(String uuid){
        utilisateurService.deleteUtilisateurDto(uuid);
    }
}
