import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.List;

public class FakeScriptEngineFactory implements ScriptEngineFactory {
    public FakeScriptEngineFactory() {
        new Exception("Where is the cat?").printStackTrace();
        System.err.println("***** I FOUND THE CAT *****");
        System.exit(1);
    }

    @Override
    public String getEngineName() {
        return null;
    }

    @Override
    public String getEngineVersion() {
        return null;
    }

    @Override
    public List<String> getExtensions() {
        return null;
    }

    @Override
    public List<String> getMimeTypes() {
        return null;
    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public String getLanguageName() {
        return null;
    }

    @Override
    public String getLanguageVersion() {
        return null;
    }

    @Override
    public Object getParameter(final String key) {
        return null;
    }

    @Override
    public String getMethodCallSyntax(final String obj, final String m, final String... args) {
        return null;
    }

    @Override
    public String getOutputStatement(final String toDisplay) {
        return null;
    }

    @Override
    public String getProgram(final String... statements) {
        return null;
    }

    @Override
    public ScriptEngine getScriptEngine() {
        return null;
    }
}
