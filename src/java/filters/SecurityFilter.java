package filters;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Slightom
 */
@Provider
//@Logowanie
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        final String authorization = requestContext.getHeaderString("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {

            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));

            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            String login = values[0];
            String password = values[1];
            System.out.println(login + " " + password);

            if (login.equals("peter") && password.equals("qwerty")) {
                System.out.println("Good");
                return;
            } else {
                Response unauthorized = Response
                        .status(Response.Status.UNAUTHORIZED)
                        .entity("Brak dostępu").build();
                
                requestContext.abortWith(unauthorized);
            }
        }

    }
}
