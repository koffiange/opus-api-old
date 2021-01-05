package ci.siracide.pole.opus.service;

import ci.siracide.pole.opus.domain.Communaute;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommunauteService implements PanacheRepositoryBase<Communaute, String> {

}
