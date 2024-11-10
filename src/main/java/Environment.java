import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, String> environmentVariables;

    public Environment() {
        environmentVariables = new HashMap<>();
        loadDefaultEnvVars();
    }

    private void loadDefaultEnvVars() {
        environmentVariables.put("PATH", "/usr/bin:/bin:/usr/local/bin");
        environmentVariables.put("HOME", System.getProperty("user.home"));
        environmentVariables.put("USER", System.getProperty("user.name"));
    }

    public String get(String key) {
        return environmentVariables.getOrDefault(key, "");
    }

    public Map<String, String> getEnv() {
        return environmentVariables;
    }

    public void set(String key, String value) {
        environmentVariables.put(key, value);
    }
}
