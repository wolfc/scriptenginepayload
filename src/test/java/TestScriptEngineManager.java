import jakarta.servlet.ServletException;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.ScriptEngineManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestScriptEngineManager {
    @BeforeClass
    public static void beforeClass() throws ServletException {
        Main.main(new String[]{});
    }

    @Test
    public void test1() throws MalformedURLException {
        final ScriptEngineManager manager = new ScriptEngineManager(new URLClassLoader(new URL[] {new URL("http://localhost:9090")}));
    }
}
