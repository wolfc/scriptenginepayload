import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;
import jakarta.servlet.ServletException;

public class Main {
    public static void main(final String[] args) throws ServletException {
        final ServletContainer container = ServletContainer.Factory.newInstance();
        final DeploymentInfo deployment = Servlets.deployment()
                .addServlet(Servlets.servlet(PayloadServlet.class)
                        .addMapping("/*")
                        .setLoadOnStartup(1))
                .setClassLoader(Thread.currentThread().getContextClassLoader())
                .setContextPath("/")
                .setDeploymentName("payload.war");
        final DeploymentManager deploymentManager = container.addDeployment(deployment);
        deploymentManager.deploy();
        final HttpHandler handler = deploymentManager.start();
        final Undertow server = Undertow.builder()
                .addHttpListener(9090, "localhost")
                .setHandler(handler)
                .build();
        server.start();
    }
}
