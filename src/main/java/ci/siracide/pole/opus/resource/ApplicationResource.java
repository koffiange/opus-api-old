package ci.siracide.pole.opus.resource;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="OPUS/JOC API",
                version = "1.0.0",
                contact = @Contact(
                        name = "SIRACIDE / JOC / Koffi Ange Stéphane (Développeur)",
                        email = "koffiange62@gmail.com"))
)
public class ApplicationResource extends Application {
}
