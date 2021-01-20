package ci.siracide.pole.opus.service;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class AppRequestInterceptorLogger implements ContainerRequestFilter {
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Context
    UriInfo info;

    @Context
    HttpHeaders httpHeaders;

    @Context
    Request request;

    @Override
    public void filter(ContainerRequestContext context) {

        final String method = context.getMethod();
        final String path = info.getPath();
        LOG.info("Requête << "+method+" : "+path);
    }
}
